package Graphs;
import java.util.*;

public class kosarajuAlgo {
    static class Edge{
        int src;
        int des;
        public Edge(int s, int d){
            this.src = s;
            this.des = d;
        }
    }
    public static void creteGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3,4));
    }
    public static void topsort(ArrayList<Edge> graph[], int curr, Stack s, boolean visit[]){
        visit[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.des]){
                topsort(graph, e.des, s, visit);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visit[]){
        visit[curr] = true;
        System.out.print(curr + " ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visit[e.des]){
                dfs(graph, e.des, visit);
            }
        }
    }
    public static void Algo(ArrayList<Edge> graph[], int v){
        Stack<Integer> s = new Stack<>();
        boolean visit[] = new boolean[v];

        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                topsort(graph, i, s, visit);
            }
        }
        //step 2
        ArrayList<Edge> secondgraph[] = new ArrayList[v];
        for(int i=0;i<v;i++){
            visit[i] = false;
            secondgraph[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();i++){
                Edge e = graph[i].get(j);
                secondgraph[e.des].add(new Edge(e.des, e.src));
            }
        }
        //step 3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!visit[curr]){
                dfs(secondgraph, curr, visit);
                System.out.println();
            }
            
        }
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];
        creteGraph(graph);
        Algo(graph, v);
    }
}
