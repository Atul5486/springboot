package com.Basic_Authentication.repository;

import com.Basic_Authentication.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPRepository extends JpaRepository<OTP,Long> {

    public OTP findByOtp(String otp);

}
