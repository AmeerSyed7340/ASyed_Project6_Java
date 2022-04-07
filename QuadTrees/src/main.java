import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class QtNode{
    public int color;
    public int upperR;
    public int upperC;
    public int Size;
    QtNode NWkid = null;
    QtNode NEkid = null;
    QtNode SWkid = null;
    QtNode SEkid = null;

    public QtNode(int upperR, int upperC, int Size, QtNode NWkid, QtNode NEkid, QtNode SWkid, QtNode SEkid){
        this.upperR = upperR;
        this.upperC = upperC;
        this.Size = Size;
        this.NWkid = NWkid;
        this.NEkid = NEkid;
        this.SWkid = SWkid;
        this.SEkid = SEkid;
    }//constructor

    public void printQtNode(QtNode node, File outFile){

    }//printQtNode
} //End class QtNode

class QuadTree{
    int numRows;
    int numCols;
    int minVal;
    int maxVal;
    int power2;
    int [][] imgAry;
    QtNode QtRoot = null;

    public QuadTree(int numRows, int numCols, int minVal, int maxVal){
        this.numRows = numRows;
        this.numCols = numCols;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }//constructor

    public int computePower2(int numRows, int numCols){
        int max = 0;
        max = Math.max(numRows, numCols);
        int size = max;
        power2 = 2;
        while(size > power2){
            power2 *= 2;
        }
        return power2;
    }//computePower2

    public void loadImage(File inFile,int[][] imgAry){
    Scanner sc = null;
    String stS = null;
    int data = 0;
    int r,c;
    try{
        sc = new Scanner(inFile);
    }catch(IOException e){

    }
    sc.nextLine();
    r= 0;
    while(sc.hasNext()){
        while(r < numRows){
            c = 0;
            while(c < numCols){
               stS = sc.next();
               data = Integer.parseInt(stS);
               imgAry[r][c] = data;
               c++;
            }
            r++;
        }
    }
    }//loadImage

    public void zero2DAry(){

    }//zero2DAry

    public QtNode buildQuadTree(){
        return null;
    }//buildQuadTree

    public void sumKidsColor(QtNode node){

    }//sumKidsColor

    public void setLeaf(QtNode node){

    }//setLeaf

    public boolean isLeaf(QtNode node){
        return false;
    }//isLeaf

    public void preOrder(){

    }//preOrder

    public void postOrder(){

    }//postOrder
}

public class main {
    public static void main(String[] args) {
        FileWriter fw;
        PrintWriter pw = null;
        File f1 = null;
        File outFile2 = new File("outFile2.txt");
        Scanner sc = null;
        Scanner scFirstLine = null;
        try{
            f1 = new File("G:\\SchoolDloads\\QC2021-2022\\Spring_2022\\DesignAndAnalysis\\Codes\\ASyed_Project6_Java\\QuadTrees\\src\\inFile.txt");
            sc = new Scanner(f1);
            fw = new FileWriter(outFile2);
            pw =new PrintWriter(fw);
        }
        catch(IOException e){

        }
        String firstLine = sc.nextLine();
        String rowS, colS, minValS, maxValS;
        int rowI = 0;
        int colI = 0;
        int minValI = 0;
        int maxValI = 0;
        scFirstLine = new Scanner(firstLine);
        scFirstLine.useDelimiter(" ");
        while(scFirstLine.hasNext()){
            rowS = scFirstLine.next();
            colS = scFirstLine.next();
            minValS = scFirstLine.next();
            maxValS = scFirstLine.next();
            rowI = Integer.parseInt(rowS);
            colI = Integer.parseInt(colS);
            minValI = Integer.parseInt(minValS);
            maxValI = Integer.parseInt(maxValS);
        }
        QuadTree qt = new QuadTree(rowI, colI, minValI, maxValI);
        //System.out.println(qt.numRows + " " + qt.numCols + " " +qt.minVal + " " + qt.maxVal);
        int power2 = qt.computePower2(qt.numRows, qt.numCols);
        pw.print("power2: " + power2);
        pw.println();
        qt.imgAry = new int [power2][power2];
        qt.loadImage(f1,qt.imgAry);

        for(int i = 0; i < qt.imgAry.length; i++){
            for(int j = 0; j < qt.imgAry.length; j++){
                pw.print(qt.imgAry[i][j]);
            }
            pw.println();
        }
        pw.close();
        sc.close();
    }


}//outer main
