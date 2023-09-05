package com.nissan.lib;

public class ValidateMethods {

	public String validateName(String name) {
		if (name.matches("[A-Za-z][a-z]*") && name.length()>=2 && name.length()<=30) {
			return name;
		}
		return null;
	}
	
	public String validateMobileNumber(String mNumber) {
		if (mNumber.matches("[0-9]*") && mNumber.length()==10) {
			return mNumber;
		}
		return null;
	}
	
	public String validateNumeric(String number) {
		if (number.matches("[0-9]{1,13}(\\.[0-9]*)?")){
			return number;
		}
		return null;
	}
}
