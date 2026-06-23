package com.Basic_Authentication.utils;

public class Utils {
    public static final String otpMail = """
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body style="margin:0;padding:0;background-color:#f4f4f4;font-family:Arial,sans-serif;">
    <table width="100%%" cellpadding="0" cellspacing="0">
        <tr>
            <td align="center">
                <table width="600" cellpadding="0" cellspacing="0"
                       style="background:#ffffff;margin:20px auto;border-radius:10px;overflow:hidden;">
                    
                    <tr>
                        <td style="background:#4F46E5;padding:25px;text-align:center;">
                            <h1 style="color:white;margin:0;">OTP Verification</h1>
                        </td>
                    </tr>

                    <tr>
                        <td style="padding:30px;">
                            <h2>Hello User,</h2>
                            <p>Your One-Time Password (OTP) for account verification is:</p>

                            <div style="text-align:center;margin:30px 0;">
                                <span style="display:inline-block;
                                             background:#EEF2FF;
                                             color:#4F46E5;
                                             font-size:32px;
                                             font-weight:bold;
                                             letter-spacing:8px;
                                             padding:15px 30px;
                                             border-radius:8px;">
                                    %s
                                </span>
                            </div>

                            <p>This OTP is valid for <b>5 minutes</b>.</p>
                            <p>Please do not share it with anyone.</p>

                            <br>
                            <p>Thanks,<br><b>Authentication Team</b></p>
                        </td>
                    </tr>

                    <tr>
                        <td style="background:#f4f4f4;padding:15px;text-align:center;color:#666;">
                            © 2026 BridgeFix. All rights reserved.
                        </td>
                    </tr>

                </table>
            </td>
        </tr>
    </table>
</body>
</html>
""";

public static final String profileUpdateMail = """
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body style="margin:0;padding:0;background:#f4f4f4;font-family:Arial,sans-serif;">
    <table width="100%%" cellpadding="0" cellspacing="0">
        <tr>
            <td align="center">
                <table width="600" cellpadding="0" cellspacing="0"
                       style="background:#ffffff;margin:20px auto;border-radius:10px;overflow:hidden;">

                    <tr>
                        <td style="background:#10B981;padding:25px;text-align:center;">
                            <h1 style="color:white;margin:0;">Profile Updated</h1>
                        </td>
                    </tr>

                    <tr>
                        <td style="padding:30px;">
                            <h2>Hello User,</h2>

                            <p>Your profile has been successfully updated.</p>

                            <table width="100%%"
                                   style="border-collapse:collapse;margin-top:20px;">
                                <tr>
                                    <td style="padding:12px;border:1px solid #ddd;">
                                        Updated By
                                    </td>
                                    <td style="padding:12px;border:1px solid #ddd;font-weight:bold;">
                                        %s
                                    </td>
                                </tr>

                                <tr>
                                    <td style="padding:12px;border:1px solid #ddd;">
                                        Role
                                    </td>
                                    <td style="padding:12px;border:1px solid #ddd;">
                                        %s
                                    </td>
                                </tr>
                            </table>

                            <p style="margin-top:20px;">
                                If you did not make this change, please contact support immediately.
                            </p>

                            <br>
                            <p>Regards,<br><b>Account Security Team</b></p>
                        </td>
                    </tr>

                    <tr>
                        <td style="background:#f4f4f4;padding:15px;text-align:center;color:#666;">
                            © 2026 BridgeFix . All rights reserved.
                        </td>
                    </tr>

                </table>
            </td>
        </tr>
    </table>
</body>
</html>
""";

}
