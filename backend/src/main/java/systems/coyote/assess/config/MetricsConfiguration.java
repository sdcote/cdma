package systems.coyote.assess.config;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.jmx.JmxReporter;
import com.codahale.metrics.jvm.*;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.management.ManagementFactory;

/**
 * Configuration of Dropwizard metrics
 * Those configurations are accessible via {@code /metrics} endpoint
 * or via the JMX
 */
@EnableMetrics(proxyTargetClass = true)
@Configuration
public class MetricsConfiguration extends MetricsConfigurerAdapter {

    private static final String PROP_METRIC_REG_JVM_MEMORY = "jvm.memory";
    private static final String PROP_METRIC_REG_JVM_GARBAGE = "jvm.garbage";
    private static final String PROP_METRIC_REG_JVM_THREADS = "jvm.threads";
    private static final String PROP_METRIC_REG_JVM_FILES = "jvm.files";
    private static final String PROP_METRIC_REG_JVM_BUFFERS = "jvm.buffers";
    private static final String PROP_METRIC_REG_JVM_ATTRIBUTE_SET = "jvm.attributes";

    private final HikariDataSource hikariDataSource;

    public MetricsConfiguration(HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    @Bean
    @Override
    public MetricRegistry getMetricRegistry() {
        MetricRegistry metricRegistry = new MetricRegistry();
        registerJVMMetrics(metricRegistry);
        registerDatasourceMetrics(metricRegistry);
        reportMetricsViaJMX(metricRegistry);
        return metricRegistry;
    }

    @Bean
    @Override
    public HealthCheckRegistry getHealthCheckRegistry() {
        return new HealthCheckRegistry();
    }

    private void registerJVMMetrics(MetricRegistry metricRegistry) {
        metricRegistry.register(PROP_METRIC_REG_JVM_MEMORY, new MemoryUsageGaugeSet());
        metricRegistry.register(PROP_METRIC_REG_JVM_GARBAGE, new GarbageCollectorMetricSet());
        metricRegistry.register(PROP_METRIC_REG_JVM_THREADS, new ThreadStatesGaugeSet());
        metricRegistry.register(PROP_METRIC_REG_JVM_FILES, new FileDescriptorRatioGauge());
        metricRegistry.register(PROP_METRIC_REG_JVM_BUFFERS, new BufferPoolMetricSet(ManagementFactory.getPlatformMBeanServer()));
        metricRegistry.register(PROP_METRIC_REG_JVM_ATTRIBUTE_SET, new JvmAttributeGaugeSet());
    }

    private void registerDatasourceMetrics(MetricRegistry metricRegistry) {
        hikariDataSource.setMetricRegistry(metricRegistry);
    }

    private void reportMetricsViaJMX(MetricRegistry metricRegistry) {
        JmxReporter jmxReporter = JmxReporter.forRegistry(metricRegistry).build();
        jmxReporter.start();
    }

}
