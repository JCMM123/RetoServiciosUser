package io.swagger.petstore.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelCode {

    public static ArrayList<Map<String, String>> leerDatosDeHojaDeExcel(String rutaDeExcel, String hojaDeExcel) throws IOException {
        ArrayList<Map<String, String>> arrayListDatoPlanTrabajo = new ArrayList();
        Map<String, String> informacionProyecto = new HashMap();
        File file = new File(rutaDeExcel);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(hojaDeExcel);
        Iterator<Row> rowIterator = newSheet.iterator();
        Row titulos = rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.getColumnIndex();
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(), cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(), String.valueOf((long) cell.getNumericCellValue()));
                        break;
                    case BLANK:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(), "");
                        break;
                    default:
                }
            }
            arrayListDatoPlanTrabajo.add(informacionProyecto);
            informacionProyecto = new HashMap();
        }
        return arrayListDatoPlanTrabajo;
    }
    public static void escribirEnExcel(String rutaDeExcel, String hojaDeExcel, int fila, String nombreColumna, String valor) throws IOException {
        FileInputStream inputStream = new FileInputStream(rutaDeExcel);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(hojaDeExcel);
        Row row = sheet.getRow(fila);
        if (row == null) {
            row = sheet.createRow(fila);
        }
        int columna = buscarColumnaPorNombre(sheet, nombreColumna);
        Cell cell = row.createCell(columna);
        cell.setCellValue(valor);
        FileOutputStream outputStream = new FileOutputStream(rutaDeExcel);
        workbook.write(outputStream);
        workbook.close();
    }

    private static int buscarColumnaPorNombre(Sheet sheet, String nombreColumna) {
        Row titulos = sheet.getRow(0);
        for (int i = 0; i < titulos.getLastCellNum(); i++) {
            Cell cell = titulos.getCell(i);
            if (cell != null && cell.getStringCellValue().equals(nombreColumna)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Columna no encontrada: " + nombreColumna);
    }
}
