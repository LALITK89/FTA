package com.selenium.fta.Pdf_Comparision;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PDFImageComparator 
{
	public static void comparePDFImages(String SourcePDFpath, String DestinationPDFpath) 
	{
        try 
        {
        	PDDocument pdf1 = PDDocument.load(new File(SourcePDFpath));
            PDDocument pdf2 = PDDocument.load(new File(DestinationPDFpath));
            
            PDFRenderer pdfRenderer1 = new PDFRenderer(pdf1);
            PDFRenderer pdfRenderer2 = new PDFRenderer(pdf2);

            BufferedImage image1 = pdfRenderer1.renderImageWithDPI(0, 300);
            BufferedImage image2 = pdfRenderer2.renderImageWithDPI(0, 300);

            boolean areImagesEqual = compareImages(image1, image2);

            if (areImagesEqual) 
            {
                System.out.println("The PDFs are visually identical.");
            } 
              else 
               {
                System.out.println("The PDFs are visually different.");
               }

            pdf1.close();
            pdf2.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    private static boolean compareImages(BufferedImage img1, BufferedImage img2) 
    {
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) 
        {
            return false;
        }

        for (int y = 0; y < img1.getHeight(); y++) 
        {
            for (int x = 0; x < img1.getWidth(); x++) 
            {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)) 
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) 
    {
        String SourcePDFpath = "D:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\Desktop\\Natural Person Tax Agent Registration Provisional Certificate.pdf";
        String DestinationPDFpath = "D:\\OneDrive - Invenio Business Solutions Pvt. Ltd\\Desktop\\Open Air.pdf";
        comparePDFImages(SourcePDFpath, DestinationPDFpath);
    }
}
