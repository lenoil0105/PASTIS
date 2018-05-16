package s03;

import java.util.Random;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PastisModel implements IPastisModel{

	StringProperty pasProperty = new SimpleStringProperty();
	IntegerProperty lenght = new SimpleIntegerProperty(12);
	BooleanProperty Uc = new SimpleBooleanProperty();
	BooleanProperty Lc = new SimpleBooleanProperty();
	BooleanProperty digits= new SimpleBooleanProperty();
	BooleanProperty sym = new SimpleBooleanProperty();
	BooleanProperty unam = new SimpleBooleanProperty();
	Random r = new Random();
	
	@Override
	public int getLength() {
		return lenght.get();
	}

	@Override
	public void setLength(int length) {
		this.lenght.set(length);
	}

	@Override
	public boolean hasUcLetters() {
		// TODO Auto-generated method stub
		return Uc.get();
	}

	@Override
	public void setUcLetters(boolean ucLetters) {
		// TODO Auto-generated method stub
		Uc.set(ucLetters);
	}

	@Override
	public boolean hasLcLetters() {
		// TODO Auto-generated method stub
		return Lc.get();
	}

	@Override
	public void setLcLetters(boolean lcLetters) {
		// TODO Auto-generated method stub
		Lc.set(lcLetters);
	}

	@Override
	public boolean hasDigits() {
		// TODO Auto-generated method stub
		return digits.get();
	}

	@Override
	public void setDigits(boolean digits) {
		// TODO Auto-generated method stub
		this.digits.set(digits);
	}

	@Override
	public boolean hasSymbols() {
		// TODO Auto-generated method stub
		return sym.get();
	}

	@Override
	public void setSymbols(boolean symbols) {
		// TODO Auto-generated method stub
		sym.set(symbols);
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
		return unam.get();
	}

	@Override
	public void setUnambiguous(boolean unambiguous) {
		// TODO Auto-generated method stub
		unam.set(unambiguous);
	}

	@Override
	public String generateNewPassword() {
		// TODO Auto-generated method stub
		String pass = new String();
		String sPool = new String();
		if(Uc.get()){
			sPool+= IPastisModel.UC_CONSONANTS+IPastisModel.UC_VOWELS;
		}
		if(Lc.get()){
			sPool+=IPastisModel.LC_CONSONANTS+IPastisModel.LC_VOWELS;
		}
		if(sym.get()){
			sPool+=IPastisModel.SYMBOLS;
		}
		if(digits.get())sPool+=getDigits();
		for(int i = 0;i<lenght.get();i++){
			pass+=sPool.charAt(r.nextInt(sPool.length()));
		}
		return pass;
	}

}