package s03;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PastisModel implements IPastisModel{

	StringProperty pasProperty = new SimpleStringProperty();
	
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLength(int length) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasUcLetters() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUcLetters(boolean ucLetters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasLcLetters() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLcLetters(boolean lcLetters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasDigits() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDigits(boolean digits) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasSymbols() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSymbols(boolean symbols) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPronounceable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPronounceable(boolean pronounceable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUnambiguous() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUnambiguous(boolean unambiguous) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String generateNewPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
