package org.cobra.services;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import org.cobra.models.EmpDetails;

public class UserTable {

    public Table getEmpNameAndAddress(EmpDetails emp, PdfFont boldTxt, int fontSize, Color color){

        Paragraph empNamePara = new Paragraph().add(setTextWithStyle("Name:",boldTxt,fontSize,color));
        Paragraph currEmpNamePara = new Paragraph().add(setTextWithStyle(emp.getName(),boldTxt,fontSize,color));

        Paragraph empFatherPara = new Paragraph().add(setTextWithStyle("Father's Name:",boldTxt,fontSize,color));
        Paragraph currEmpFatherNamePara = new Paragraph().add(setTextWithStyle(emp.getFatherName(),boldTxt,fontSize,color));
        Paragraph empAddPara = new Paragraph().add(setTextWithStyle("Add:",boldTxt,fontSize,color));
        Paragraph currEmpAddPara = new Paragraph().add(setTextWithStyle(emp.getAddress(),boldTxt,fontSize,color));

        Paragraph empDesignation = new Paragraph().add(setTextWithStyle("Designation:",boldTxt,fontSize,color));
        Paragraph currEmpDesignationPara = new Paragraph().add(setTextWithStyle(emp.getDesignation(),boldTxt,fontSize,color));


        Table employeeName = new Table (new float[]{80,200});
        employeeName.addCell(createCell(empNamePara));
        employeeName.addCell(createCell(currEmpNamePara));

        employeeName.addCell(createCell(empFatherPara));
        employeeName.addCell(createCell(currEmpFatherNamePara));
        employeeName.addCell(createCell(empAddPara));
        employeeName.addCell(createCell(currEmpAddPara));
        employeeName.addCell(createCell(empDesignation));
        employeeName.addCell(createCell(currEmpDesignationPara));



        return employeeName;

    }

    public Table getEmpPost(EmpDetails emp, PdfFont boldTxt, int fontSize, Color color){

        Paragraph empRegNo = new Paragraph().add(setTextWithStyle("Reg. No:",boldTxt,fontSize,color));
        Paragraph currEmpRegNoPara = new Paragraph().add(setTextWithStyle(emp.getRegNo(),boldTxt,fontSize,color));
        Paragraph empJoiningDate = new Paragraph().add(setTextWithStyle("Joining Date:",boldTxt,fontSize,color));
        Paragraph currEmpJoiningDatePara = new Paragraph().add(setTextWithStyle(emp.getJoiningDate(),boldTxt,fontSize,color));

        Table employeePost = new Table (new float[]{40,40,70,90});
        employeePost.addCell(createCell(empRegNo).setBorder(Border.NO_BORDER));
        employeePost.addCell(createCell(currEmpRegNoPara).setBorder(Border.NO_BORDER));
        employeePost.addCell(createCell(empJoiningDate).setBorder(Border.NO_BORDER));
        employeePost.addCell(createCell(currEmpJoiningDatePara).setBorder(Border.NO_BORDER));

        return employeePost;


    }
    public Table getDobAndBloodGroup(EmpDetails emp, PdfFont boldTxt, int fontSize, Color color){

        Paragraph empDesignation = new Paragraph().add(setTextWithStyle("D.O.B:",boldTxt,fontSize,color));
        Paragraph currEmpDesignationPara = new Paragraph().add(setTextWithStyle(emp.getDob(),boldTxt,fontSize,color));
        Paragraph empJoiningDate = new Paragraph().add(setTextWithStyle("Blood Group:",boldTxt,fontSize,color));
        Paragraph currEmpJoiningDatePara = new Paragraph().add(setTextWithStyle(emp.getBloodGroup(),boldTxt,fontSize,color));

        Table employeeOptional = new Table (new float[]{30,50,50,50});
        employeeOptional.addCell(createCell(empDesignation));
        employeeOptional.addCell(createCell(currEmpDesignationPara));
        employeeOptional.addCell(createCell(empJoiningDate));
        employeeOptional.addCell(createCell(currEmpJoiningDatePara));

        return employeeOptional;


    }

    private Cell createCell(Paragraph val){
       return new Cell().add(val).setBorder(Border.NO_BORDER).setMargin(0).setPadding(0);
    }

    private Text setTextWithStyle(String val, PdfFont font, int fontSize, Color color){
        return new Text(val).setFont(font).setFontSize(fontSize-2).setFontColor(color);

    }

}
