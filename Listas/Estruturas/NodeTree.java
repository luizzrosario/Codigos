package Estruturas;

public class NodeTree {
    class DataType {
        int numero;

        public DataType(int n){
            this.numero = n;
        }
    }    

    DataType info;
    NodeTree left;
    NodeTree right;
    NodeTree father;
}
