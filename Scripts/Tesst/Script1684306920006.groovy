import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

//exercise 04: Nhập số N
PhuongTruong.exercise4(0)

public class PhuongTruong{
	//exercise 04
	public static ArrayList<String> exercise4(int numberOfCharacter) {
		def charactes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		def	list =[]
		if (numberOfCharacter <= charactes.size() && numberOfCharacter > 0) {
		while (list.size() < numberOfCharacter) {
			Random random = new Random ();
			def index = random.nextInt(charactes.length());
			def indexNumber = charactes.charAt(index);
				if (!list.contains(indexNumber)) {
					list.add(indexNumber);
				}
		}
		println("Random list = " + list);
	}
	else println ("Thôi đừng test nữa! Vui lòng nhập trong range 1-36")
	}
}