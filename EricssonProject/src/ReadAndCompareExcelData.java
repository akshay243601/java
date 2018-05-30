
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class OfferData {

	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getAccumulatorDefinitionGroup() {
		return accumulatorDefinitionGroup;
	}

	public void setAccumulatorDefinitionGroup(String accumulatorDefinitionGroup) {
		this.accumulatorDefinitionGroup = accumulatorDefinitionGroup;
	}

	public String getAccumulatorId() {
		return accumulatorId;
	}

	public void setAccumulatorId(String accumulatorId) {
		this.accumulatorId = accumulatorId;
	}

	public String getDaDefinitionGroup() {
		return daDefinitionGroup;
	}

	public void setDaDefinitionGroup(String daDefinitionGroup) {
		this.daDefinitionGroup = daDefinitionGroup;
	}

	public String getDaID() {
		return daID;
	}

	public void setDaID(String daID) {
		this.daID = daID;
	}

	public String getUsageCounter() {
		return usageCounter;
	}

	public void setUsageCounter(String usageCounter) {
		this.usageCounter = usageCounter;
	}

	public String getUsageThreshold() {
		return usageThreshold;
	}

	public void setUsageThreshold(String usageThreshold) {
		this.usageThreshold = usageThreshold;
	}

	public boolean isMatched() {
		return isMatched;
	}

	public void setMatched(boolean isMatched) {
		this.isMatched = isMatched;
	}

	public boolean isPrimaryDataSheet() {
		return isPrimaryDataSheet;
	}

	public void setPrimaryDataSheet(boolean isPrimaryDataSheet) {
		this.isPrimaryDataSheet = isPrimaryDataSheet;
	}

	private String offerId;
	private String accumulatorDefinitionGroup;
	private String accumulatorId;
	private String daDefinitionGroup;
	private String daID;
	private String usageCounter;
	private String usageThreshold;
	private boolean isMatched;
	private boolean isPrimaryDataSheet;

	@Override
	public int hashCode() {
		return this.getOfferId().hashCode() + this.getAccumulatorDefinitionGroup().hashCode()
				+ this.getAccumulatorId().hashCode() + this.getDaDefinitionGroup().hashCode()
				+ this.getDaID().hashCode() + this.getUsageCounter().hashCode() + this.getUsageThreshold().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		OfferData node = (OfferData) obj;
		OfferData primaryD = this;
		return node.getOfferId().equals(primaryD.getOfferId())
				&& node.getAccumulatorDefinitionGroup().equals(primaryD.getAccumulatorDefinitionGroup())
				&& node.getAccumulatorId().equals(primaryD.getAccumulatorId())
				&& node.getDaDefinitionGroup().equals(primaryD.getDaDefinitionGroup())
				&& node.getDaID().equals(primaryD.getDaID())
				&& node.getUsageCounter().equals(primaryD.getUsageCounter())
				&& node.getUsageThreshold().equals(primaryD.getUsageThreshold());
	}
}

public class ReadAndCompareExcelData {

	public static LinkedHashMap<OfferData, OfferData> primaryData = new LinkedHashMap<OfferData, OfferData>();

	public static void main(String[] args) throws IOException {
		LinkedHashMap<String, LinkedHashMap<OfferData, OfferData>> mismatchData = getMismatchData();
		writeExcel(mismatchData,
				"D:\\Personnel\\Git-Repository\\Git-Java\\java\\EricssonProject\\src\\MISMATCH_DATA.xlsx");

	}

	private static LinkedHashMap<String, LinkedHashMap<OfferData, OfferData>> getMismatchData() throws IOException {
		LinkedHashMap<String, LinkedHashMap<OfferData, OfferData>> data = prepareNodeOfferData();
		LinkedHashMap<String, LinkedHashMap<OfferData, OfferData>> mismatchData = new LinkedHashMap<String, LinkedHashMap<OfferData, OfferData>>();

		for (Entry<String, LinkedHashMap<OfferData, OfferData>> offerDataMap : data.entrySet()) {
			LinkedHashMap<OfferData, OfferData> mismatchNodeData = new LinkedHashMap<OfferData, OfferData>();
			LinkedHashMap<OfferData, OfferData> nodeData = offerDataMap.getValue();
			for (Entry<OfferData, OfferData> nodeDataV : nodeData.entrySet()) {
				if (!primaryData.containsKey(nodeDataV.getKey())) {
					mismatchNodeData.put(nodeDataV.getKey(), nodeDataV.getValue());
				}
			}
			mismatchData.put(offerDataMap.getKey(), mismatchNodeData);
		}

		System.out.println(mismatchData);
		return mismatchData;
	}

	public static void writeExcel(LinkedHashMap<String, LinkedHashMap<OfferData, OfferData>> mismatchData,
			String excelFilePath) throws IOException {
		Workbook workbook = new XSSFWorkbook();

		for (Entry<String, LinkedHashMap<OfferData, OfferData>> row : mismatchData.entrySet()) {
			int rowCount = 0;
			Sheet sheet = workbook.createSheet(row.getKey());
			for (Entry<OfferData, OfferData> data : row.getValue().entrySet()) {
				Row rowData = sheet.createRow(++rowCount);
				writeOfferData(data.getValue(), rowData);
			}
		}

		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}

	private static void writeOfferData(OfferData offerData, Row row) {
		Cell cell = row.createCell(0);
		cell.setCellValue(offerData.getOfferId());

		cell = row.createCell(1);
		cell.setCellValue(offerData.getAccumulatorDefinitionGroup());

		cell = row.createCell(2);
		cell.setCellValue(offerData.getAccumulatorId());

		cell = row.createCell(3);
		cell.setCellValue(offerData.getDaDefinitionGroup());

		cell = row.createCell(4);
		cell.setCellValue(offerData.getDaID());

		cell = row.createCell(5);
		cell.setCellValue(offerData.getUsageCounter());

		cell = row.createCell(6);
		cell.setCellValue(offerData.getUsageThreshold());
	}

	private static LinkedHashMap<String, LinkedHashMap<OfferData, OfferData>> prepareNodeOfferData()
			throws IOException {
		LinkedHashMap<String, LinkedHashMap<OfferData, OfferData>> map = new LinkedHashMap<String, LinkedHashMap<OfferData, OfferData>>();
		String excelFilePath = "D:\\Personnel\\Git-Repository\\Git-Java\\java\\EricssonProject\\src\\NIgeria _Database_MTN.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		int count = workbook.getNumberOfSheets();

		for (int i = 0; i < count; i++) {
			LinkedHashMap<OfferData, OfferData> mapData = new LinkedHashMap<OfferData, OfferData>();
			Sheet sheet = workbook.getSheetAt(i);
			Iterator<Row> iterator = sheet.iterator();
			if (iterator.hasNext()) {
				iterator.next();
			}
			boolean isPrimaryData = false;
			if ("Primary".equalsIgnoreCase(sheet.getSheetName())) {
				isPrimaryData = true;
			}
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				OfferData offerData = new OfferData();
				offerData.setOfferId(String.valueOf( getCellValue(nextRow.getCell(0))));
				offerData.setAccumulatorDefinitionGroup(String.valueOf(getCellValue(nextRow.getCell(1))));
				offerData.setAccumulatorId(String.valueOf(getCellValue(nextRow.getCell(2))));
				offerData.setDaDefinitionGroup(String.valueOf(getCellValue(nextRow.getCell(3))));
				offerData.setDaID(String.valueOf(getCellValue(nextRow.getCell(4))));
				offerData.setUsageCounter(String.valueOf(getCellValue(nextRow.getCell(5))));
				offerData.setUsageThreshold(String.valueOf(getCellValue(nextRow.getCell(6))));
				if (isPrimaryData) {
					primaryData.put(offerData, offerData);
				} else {
					mapData.put(offerData, offerData);
				}

			}

			map.put(sheet.getSheetName(), mapData);
		}
		workbook.close();
		inputStream.close();
		return map;
	}

	private static Object getCellValue(Cell cell) {
		if (cell == null) {
			return "";
		}

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return (int)cell.getNumericCellValue();
		case Cell.CELL_TYPE_BLANK:
			return "";
		
		}

		return "";
	}

}
