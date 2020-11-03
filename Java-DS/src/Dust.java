public class Dust {

    public static void main(String[] args) {
        String s = "bfndbmbgdnfgbmdbgndfbngbdmbgndbmgnbdmgbmndf\"content\": \"Paytm never calls you asking for OTP. Sharing OTP gives anyone full access to Paytm balance. OTP for linking your Paytm account to SDSKIPLOGIN is  467120 .\", dfdnfndvbnnbsvfbnvsnfbvbnsdfvnsvf";
        System.out.println(getOtp(s));
    }

    private static String getOtp(String json) {
        String token = "Paytm never calls you asking for OTP. Sharing OTP gives anyone full access to Paytm balance. OTP for";
        int otpIndex = json.indexOf(token) + token.length();
        String otpSubString = json.substring(otpIndex);
        System.out.println(otpSubString);
        int endTokenIndex = otpSubString.indexOf(" .");
        int OTP_LENGTH = 6;
        String otpVal = otpSubString.substring(endTokenIndex - OTP_LENGTH, otpSubString.indexOf(" ."));
        System.out.println(otpVal);
        return otpVal;
    }


}
