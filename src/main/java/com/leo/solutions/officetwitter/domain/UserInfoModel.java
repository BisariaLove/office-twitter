package com.leo.solutions.officetwitter.domain;
/*
 * @author love.bisaria on 23/03/19
 */

public class UserInfoModel {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String handle;

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getHandle() {
        return handle;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    private UserInfoModel(Builder builder) {
        userId = builder.userId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        handle = builder.handle;
    }


    public static final class Builder {
        private Integer userId;
        private String firstName;
        private String lastName;
        private String email;
        private String handle;

        public Builder() {
        }

        public Builder(UserInfoModel copy) {
            this.userId = copy.getUserId();
            this.firstName = copy.getFirstName();
            this.lastName = copy.getLastName();
            this.email = copy.getEmail();
            this.handle = copy.getHandle();
        }

        public Builder withUserId(Integer val) {
            userId = val;
            return this;
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withHandle(String val) {
            handle = val;
            return this;
        }

        public UserInfoModel build() {
            return new UserInfoModel(this);
        }
    }
}
