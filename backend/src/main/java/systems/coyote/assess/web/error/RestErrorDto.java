package systems.coyote.assess.web.error;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * A representation for the rest error
 */
public class RestErrorDto implements Serializable {
  private String code;
  private String message;

  public RestErrorDto(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    RestErrorDto that = (RestErrorDto) o;

    return new EqualsBuilder()
        .append(code, that.code)
        .append(message, that.message)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(code)
        .toHashCode();
  }

  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this)
        .append("code", code)
        .append("message", message);

    return builder.toString();
  }
}
