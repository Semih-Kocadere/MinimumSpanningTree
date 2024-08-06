import java.lang.reflect.Array;
import java.util.ArrayList;

public class FindMST {
    private Edge[] MST = new Edge[0]; // Minimum Spanning Tree Array
    // *** You can add new variables here if necessary. ***//
    private ArrayList<Edge> resultedges= new ArrayList<>();
    private Edge[] InputGraf;
    private int[] vertexs;
    private int counter=0;




    /** Constructor */
    public FindMST(Edge[] edges) {
        //Write your codes here

        this.InputGraf = edges;
        vertexs = new int[InputGraf.length*2];
        for(int i=0;i<InputGraf.length*2;i++){
            vertexs[i] = -1;
        }





    }

    /** Main calculate Minimum Spanning Tree method */
    public void calculateMST(Edge[] edges) {

        order();

            for(int i=0;i<InputGraf.length;i++){
                if(control(InputGraf[i])){
                    resultedges.add(InputGraf[i]);
                    vertexs[counter] = InputGraf[i].getVertex1();
                    counter++;
                    vertexs[counter] = InputGraf[i].getVertex2();
                }
            }
        aktarim();
    }


    /** Get cost of Minimum Spanning Tree */
    public int getMstCost() {
        //Write your codes here
        int cost = 0;
        for(int i=0 ; i < MST.length;i++){
            i+= MST[i].getWeight();
        }
        return cost;
    }

    /** Get calculated Minimum Spanning Tree ArrayList */
    public Edge[] getMST() {
        return MST;
    }

    /** Print Minimum Spanning Tree */
    public void printMST() {
        //Write your codes here
        for(int i=0;i<InputGraf.length;i++){
            System.out.println(MST[i]);
        }
    }

    public void order(){
        Edge temp;
        for(int i=0; i < InputGraf.length;i++){
            for(int j=i ; j< InputGraf.length;j++){
                if(InputGraf[j].getWeight() < InputGraf[i].getWeight()){
                    temp = InputGraf[i];
                    InputGraf[i] = InputGraf[j];
                    InputGraf[j] = InputGraf[i];
                }
            }
        }
    }
    // *** You can add new methods here if necessary. ***//


    public boolean control(Edge edge){
        for(int i=0; i < InputGraf.length*2;i++){
            if(edge.getVertex1() == vertexs[i] && edge.getVertex2() == vertexs[i]);
            return false;
        }


        return true;
    }


    public void aktarim(){
        MST = new Edge[resultedges.size()];
        for(int i=0;i<resultedges.size();i++){
            MST[i] = resultedges.get(i);
        }
    }

}
