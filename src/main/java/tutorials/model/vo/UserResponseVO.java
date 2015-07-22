package tutorials.model.vo;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@Component
public class UserResponseVO {

    private String email;

    private String password;

    private String name;

    private String address;

    private DateTime createDate;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public DateTime getCreateDate() {
        return createDate;
    }

    public static class Builder {
        private String email;
        private String password;
        private String name;
        private String address;
        private DateTime createDate;

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withCreateDate(DateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public UserResponseVO build() {
            UserResponseVO user = new UserResponseVO();
            user.email = this.email;
            user.password = this.password;
            user.name = this.name;
            user.address = this.address;
            user.createDate = this.createDate;

            return user;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserResponseVO that = (UserResponseVO) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
