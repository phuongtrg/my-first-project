import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//exercise 01: Cho 1 test data như sau :  [1, 2, 3, 4, 5, 6, 7, 8, 9] -> viết code xuất tách ra làm 2 mảng : số lẻ và số chẵn
PhuongTruong.exercise1()

//exercise 02: Cho 1 test data như sau :  [1, 2, 3, 4, 5, 6, 7, 8, 9] ->  viết code gỡ bỏ số chẵn ra khỏi test Data
println ("Answer: Mảng số lẻ sau khi đã gỡ bỏ tất cả số chẵn: " + PhuongTruong.exercise2())

//exercise 03: Viết code đếm từ [1 - 100] có bao nhiêu số chia hết cho 7 ?
PhuongTruong.exercise3()

//exercise 04: Nhập số N
PhuongTruong.exercise4(7)

//exercise 05: Nhập số N
PhuongTruong.exercise5(3)

//exercise 06: Nhập số N
println("N = :" + PhuongTruong.exercise6(3))

//exercise 07: Nhập value
PhuongTruong.exercise7("dataset")

//exercise 08: Nhập index
PhuongTruong.exercise8(1)

//exercise 09
println ("Person Information = " + PhuongTruong.exercise9())

//exercise 10
PhuongTruong.exercise10()


public class PhuongTruong{
	//exercise 01
	public static def exercise1() {
		def listOrigin =[1, 2, 3, 4, 5, 6, 7,8 , 9]
		def listOdd =[]
		def listEven =[]
			for (int i = 0; i < listOrigin.size(); i++){
				if(listOrigin[i] % 2 == 0){
					listEven.add(listOrigin[i])
				}
					else{
						listOdd.add(listOrigin[i])
					}
			}
			println ("Answer: Mảng số lẻ là: " + listOdd +". Mảng số chẵn là: " + listEven)
	}
	//exercise 02
	public static def exercise2(){
		def listOrigin = [1, 2, 3, 4, 5, 6, 7, 8, 9]
		for(int i = 0; i < listOrigin.size();i++){
			if(listOrigin[i] % 2 == 0){
					listOrigin.remove(i)
			}
		}
		return listOrigin
	}
	//exercise 03
	public static def exercise3() {
		def count = 0;
		def	listOrigin =[]
			for (int i = 1; i <= 100; i++) {
				if (i % 7 == 0) {
					count++;
					listOrigin.add(i)
				}
			}
			println ("Answer: Số lượng các số chia hết cho 7 trong khoảng từ 1-100 là: " + count + ". Đó là các số sau đây: " + listOrigin)
	}
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
	//exercise 05
	public static def exercise5(int numberOfValue) {
		def Map emptymap = [:]
		if (numberOfValue > 0) {
			for (int i = 1; i <=numberOfValue; i++) {
				emptymap.put("Key_"+ i, "Value_" +i);
			}
			println(emptymap);	
		}	else
			println("HashMap is empty!!!");
	}	
	//exercise 06
	public static ArrayList<Integer> exercise6(int numberOfElements) {
		def	List results =[]
		def value = 1
		while (results.size() < numberOfElements) {
			if ((value % numberOfElements) == 0) {
				results.add(value)
			}
			value++
		}
		return results
	}
	
	//exercise 07
	public static def exercise7(String value) {
		def listOrigin =["Java", "C#", "C++", "Python", "Golang", "Swift", "Scartch"]
		def count = 0
		for (int i = 0; i < listOrigin.size(); i++) {
			if (listOrigin[i].equalsIgnoreCase(value)) {
				def index = listOrigin.indexOf(listOrigin[i]);
				println("Index is: " + ++index);
				break;
			}
			else count ++
		}
		if (count == listOrigin.size()){
			println("Can not found!");
		}
	}
	//exercise 08
	public static def exercise8(int index) {
		def listOrigin =["Java", "C#", "C++", "Python", "Golang", "Swift", "Scartch"]
		def count = 0
		for (String val : listOrigin) {
			if (index == listOrigin.indexOf(val) + 1) {
				println("Value: " + val);
				break;
			}
			else count ++
		}
			if (count == listOrigin.size()){
				println("Can not found!");
			}
	}
	//exercise 09
	public static Map personInfo = ["name": "Phuong Dep Trai", "YearofBirth": 1989, "height": "1m72", "weight": "69kg"]
	public static def exercise9() {
		def YOB = personInfo.get("YearofBirth")
		def age = 0
		age = Calendar.getInstance().get(Calendar.YEAR) - YOB;
		personInfo.put("age", age)
		return personInfo
	}
	//exercise 10
	public static def exercise10() {
		//Weight is the number of kg
		//height is the number of meter
		def Map personInfo = ["weight": 47.4, "height": 1.72]
		def bmi = personInfo.get("weight")/ (personInfo.get("height") * personInfo.get("height"))
		def result = Math.round(bmi*10)/10
		if (result < 16) {
			println( "Thể trạng của bạn là : Gầy độ III")
		}
		else if(result < 17) {
			println("Thể trạng của bạn là : Gầy độ II")
		}
		else if(result < 18.5) {
			println("Thể trạng của bạn là : Gầy độ I")
		}
		else if(result < 25) {
			println("Thể trạng của bạn là : Bình thường")
		}
		else if(result < 30) {
			println("Thể trạng của bạn là : Thừa cân")
		}
		else if(result < 35) {
			println("Thể trạng của bạn là : Béo phì độ I")
		}
		else if(result < 40) {
			println("Thể trạng của bạn là : Béo phì độ II")
		}
		else if(result >= 40) {
			println("Thể trạng của bạn là : Béo phì độ III")
		}
		personInfo.put("BMI", result)
		println(personInfo)
	}
}