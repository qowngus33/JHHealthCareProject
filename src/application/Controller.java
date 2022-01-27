package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Controller {
	private int number = 1;

	@FXML
	private TextField food;

	@FXML
	private TextField Cal;

	@FXML
	private TextField age;

	@FXML
	private TextField weight;

	@FXML
	private TextField height;

	@FXML
	private TextField sex;

	@FXML
	private Text DailyCal;

	@FXML
	private Text foodList;

	@FXML
	private Text Basal;

	@FXML
	private Text waterCup;

	@FXML
	private Text calory;

	@FXML
	private Text water;

	@FXML
	private TextArea memo;

	@FXML
	private void entered(ActionEvent event) {
		String temp = weight.getText() + height.getText() + age.getText();
		boolean isNum = true;
		for (int i = 0; i < temp.length(); i++) {
			char ch = temp.charAt(i);
			int ascii = (int) ch;

			if (ascii > 57 || ascii < 48) {
				isNum = false;
			}
		}
		if (!isNum) {
			DailyCal.setText("Invalid input");
			Basal.setText("Enter numbers");
		} else if (weight.getText().equals("") || height.getText().equals("") || age.getText().equals("")) {
			DailyCal.setText("Enter all values");

		} else {

			if (sex.getText().equals("male")) {
				double result = 66.47 + (Integer.parseInt(weight.getText()) * 13.75)
						+ (Integer.parseInt(height.getText()) * 5) - (Integer.parseInt(age.getText()) * 6.76);
				Basal.setText(((int) result) + "");
				DailyCal.setText(((int) (result * 1.55)) + "");

			} else if (sex.getText().equals("female")) {
				double result = 655.1 + (Integer.parseInt(weight.getText()) * 9.56)
						+ (Integer.parseInt(height.getText()) * 1.85) - (Integer.parseInt(age.getText()) * 4.68);
				Basal.setText(((int) result) + "");
				DailyCal.setText(((int) (result * 1.55)) + "");

			} else {
				DailyCal.setText("Invalid input");
				Basal.setText("sex : male/femle");
			}
		}

	}

	@FXML
	private void water(ActionEvent event) {
		if (((Button) event.getSource()).getText().equals("+")) {

			waterCup.setText((Integer.parseInt(waterCup.getText()) + 1) + "");
			water.setText((Integer.parseInt(water.getText()) + 180) + "");
		} else {
			if (Integer.parseInt(waterCup.getText()) > 0) {
				waterCup.setText((Integer.parseInt(waterCup.getText()) - 1) + "");
				water.setText((Integer.parseInt(water.getText()) - 180) + "");

			} else
				waterCup.setText("0");

		}

	}

	@FXML
	private void foodPlus(ActionEvent event) {
		if (((Button) event.getSource()).getText().equals("+") &&  (food.getText().length()!=0)) {
			String string = foodList.getText() + number + ". " + food.getText() + "\n";
			foodList.setText(string);
			food.setText("");
			number++;

		} else {
			foodList.setText("");
			calory.setText("0");
			number = 1;
		}
	}

	@FXML
	private void calPlus(ActionEvent event) {
		boolean isNum = true;
		for (int i = 0; i < Cal.getText().length(); i++) {
			char ch = Cal.getText().charAt(i);
			int ascii = (int) ch;

			if (ascii > 57 || ascii < 48) {
				isNum = false;
			}
		}
		if (Cal.getText().length() != 0) {

			if (!isNum || Integer.parseInt(Cal.getText()) > 9999) {
				System.out.println("Invalid input");
				calory.setText(calory.getText());
			} else {
				calory.setText(((Integer.parseInt(Cal.getText())) + (Integer.parseInt(calory.getText()))) + "");
				Cal.setText("");
			}
		}
	}

}
