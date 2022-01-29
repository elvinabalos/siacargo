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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://www.siacargo.com/')

WebUI.click(findTestObject('track_shipment_OR/Page_Welcome to SIA Cargo/strong_Track      Shipment'))

WebUI.switchToWindowTitle('Track Shipment')

for (int i = 1; i <= 5; i++) {
    def airWayBill = WebUI.getText(findTestObject('Page_Track Shipment/span_Air Waybill 1', [('num') : i]))

    def text1 = WebUI.getAttribute(findTestObject('Page_Track Shipment/input_Air Waybill 1_Prefix1', [('prefix') : i]), 
        'value')

    def text2 = WebUI.getAttribute(findTestObject('track_shipment_OR/Page_Track Shipment/input_Air Waybill 1_Suffix1', [
                ('suffix') : i]), 'value')

    airWayBill.contains('Air WayBill ' + i)
    WebUI.verifyEqual(text1, '618')
}

WebUI.setText(findTestObject('Object Repository/track_shipment_OR/Page_Track Shipment/input_Air Waybill 1_Suffix1'), number)

WebUI.click(findTestObject('Object Repository/track_shipment_OR/Page_Track Shipment/input__btnQuery'))

WebUI.verifyElementText(findTestObject('track_shipment_OR/Page_Track Shipment/td_AWB  618-33884734'), awb)

WebUI.click(findTestObject('track_shipment_OR/Page_Track Shipment/input_Shipment Delivered_btnSearchAgain'))

WebUI.setText(findTestObject('track_shipment_OR/Page_Track Shipment/input_Air Waybill 2_Suffix2'), invalid_number)

WebUI.click(findTestObject('Object Repository/track_shipment_OR/Page_Track Shipment/input__btnQuery'))

WebUI.verifyElementText(findTestObject('Page_Track Shipment/span_Please check entries highlighted'), check_entries)

WebUI.setText(findTestObject('track_shipment_OR/Page_Track Shipment/input_Air Waybill 3_Suffix3'), invalid_number)

WebUI.click(findTestObject('Object Repository/track_shipment_OR/Page_Track Shipment/input__btnQuery'))

WebUI.verifyElementText(findTestObject('Page_Track Shipment/span_Please check entries highlighted'), check_entries)

WebUI.closeBrowser()

