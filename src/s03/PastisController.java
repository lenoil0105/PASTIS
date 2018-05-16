package s03;

public class PastisController {
	PastisModel model;

	public PastisModel init() {
		model = new PastisModel();
		// TODO Auto-generated method stub
		return model;
	}

	public String generate() {
		// TODO Auto-generated method stub
		return model.generateNewPassword();
	}

}
