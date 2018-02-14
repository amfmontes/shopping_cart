package org.o7planning.springmvcshoppingcart.view;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.springmvcshoppingcart.model.CartInfo;
import org.o7planning.springmvcshoppingcart.model.CartLineInfo;
import org.o7planning.springmvcshoppingcart.util.Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import com.memorynotfound.model.Course;

import jdk.nashorn.internal.runtime.regexp.joni.ast.CClassNode.CCStateArg;

public class ItextPdfView extends AbstractITextPdfView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
//        List<Course> courses = (List<Course>) model.get("courses");
        CartInfo cartInfo = Utils.getCartInSession(request);
        
        PdfPTable table = new PdfPTable(4);
        table.setWidths(new int[]{10, 60, 30,30});

//        cartLineInfo.productInfo.code
        table.addCell("Code");
        table.addCell("Nombre");
        table.addCell("Unidades");
        table.addCell("Precio unitario");
      
        
//        table.addCell("" +cartInfo.getOrderNum());
//        table.addCell(""+cartInfo.getCartLines());
//        table.addCell("" +cartInfo.getQuantityTotal());
//        table.addCell("" +cartInfo.getAmountTotal());
        
        

        for (CartLineInfo cartLines : cartInfo.getCartLines()){
            table.addCell(String.valueOf(cartLines.getProductInfo().getCode()));
            table.addCell(cartLines.getProductInfo().getName());
            table.addCell(""+cartLines.getQuantity());;
            table.addCell(""+cartLines.getProductInfo().getPrice());
           
//            table.addCell(DATE_FORMAT.format(cartLinesInfo.getDate()));
        }



        document.add(table);
    }}
