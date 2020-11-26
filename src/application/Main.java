package application;
	

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	
	static int [][] maze ={
			{1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
			{1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
			{1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
			{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
			{1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1},
			{1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
			{1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
			{1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
			{1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
			{1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
			{1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			};
	
	
	static Button DFS_button = new Button("DFS");
	static Button BFS_button = new Button("BFS");
	static Button increase_AnimationTime_button = new Button("+");
	static Button deacrease_AnimationTime_button = new Button("-");
	static Text Speed_Text;
	static Node root = null;
	static int row = maze.length;
	static int col = maze[0].length;
	static int mazeScale = 1280/((row+col)/2);
	static Pane pane = new Pane();
	static Rectangle [][] rect = new Rectangle [row][col];
	static boolean mazeClean = true;
	static int dealyAnimation = 1;
	static int Animation_speed = 500;


	@Override
	public void start(Stage primaryStage) {
	
			
			for (int r = 0 ; r<maze.length; r++) {
				for (int c = 0 ; c<maze[0].length; c++) {
					//System.out.println("rect["+r+"]["+c+"]");
					if(maze[r][c]==0) {
						rect[r][c]= new Rectangle (c*(mazeScale/2),r*(mazeScale/2),(mazeScale/2),(mazeScale/2));
						rect[r][c].setFill(Color.WHITE);
						pane.getChildren().add(rect[r][c]);

					}
					
					if(maze[r][c]==1) {
						rect[r][c]= new Rectangle (c*(mazeScale/2),r*(mazeScale/2),(mazeScale/2),(mazeScale/2));
						pane.getChildren().add(rect[r][c]);

					}
					else {
						if(maze[r][c]==2) {
							rect[r][c]= new Rectangle (c*(mazeScale/2),r*(mazeScale/2),(mazeScale/2),(mazeScale/2));
							rect[r][c].setFill(Color.RED);
							pane.getChildren().add(rect[r][c]);

						}
						
						if(maze[r][c]==3) {
							rect[r][c]= new Rectangle (c*(mazeScale/2),r*(mazeScale/2),(mazeScale/2),(mazeScale/2));
							rect[r][c].setFill(Color.GREEN);
							pane.getChildren().add(rect[r][c]);

						}
						
					}
				}
			}
			
			int layout_x = maze[0].length*(mazeScale/2)+maze[0].length*(mazeScale/5);
			int layout_y = maze.length*mazeScale;
			
			DFS_button.setLayoutX(layout_x);
			DFS_button.setLayoutY(layout_y*0.01);
			DFS_button.setMinWidth(layout_x/5);
			DFS_button.setMinHeight(layout_y*0.05);
			DFS_button.setFont(Font.font ("Arial", 20));
			
			BFS_button.setLayoutX(layout_x);
			BFS_button.setLayoutY(layout_y*0.07);
			BFS_button.setMinWidth(layout_x/5);
			BFS_button.setMinHeight(layout_y*0.05);
			BFS_button.setFont(Font.font ("Arial", 20));
			
			Speed_Text = new Text(layout_x, layout_y*0.17, "SPEED: "+(float)Animation_speed/1000+"s");
			System.out.print(layout_x);
			int tSize = (26*layout_x)/861;
			Speed_Text.setStyle("-fx-font: "+tSize+" arial;");
			
			increase_AnimationTime_button.setLayoutX(layout_x - layout_x * 0.1);
			increase_AnimationTime_button.setLayoutY(layout_y*0.18);
			increase_AnimationTime_button.setMinWidth(layout_x/5);
			increase_AnimationTime_button.setMinHeight(layout_y*0.05);
			increase_AnimationTime_button.setFont(Font.font ("Arial", 20));
			
			deacrease_AnimationTime_button.setLayoutX(layout_x + layout_x*0.1);
			deacrease_AnimationTime_button.setLayoutY(layout_y*0.18);
			deacrease_AnimationTime_button.setMinWidth(layout_x/5);
			deacrease_AnimationTime_button.setMinHeight(layout_y*0.05);
			deacrease_AnimationTime_button.setFont(Font.font ("Arial", 20));
			EventHandler<ActionEvent> DFSevent = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	//System.out.print("pressed");
	            	if(!mazeClean)
	            		cleanMaze();
	         
	            	DFS(root);
	            	dealyAnimation=100;
	            	mazeClean = false;
	            } 
	        }; 
	        
			EventHandler<ActionEvent> BFSevent = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	//System.out.print("pressed");
	            	if(!mazeClean)
	            		cleanMaze();
	            	
	            	BFS(root, Arrays.stream(maze).map(int[]::clone).toArray(int[][]::new));
	            	dealyAnimation=100;
	            	mazeClean = false;
	            } 
	        }; 
	        
			EventHandler<ActionEvent> Slower_Animation = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	Animation_speed+=100;
	            	Speed_Text.setText("SPEED: "+(float)Animation_speed/1000+"s");
	            } 
	        }; 
	        
			EventHandler<ActionEvent> Faster_Animition = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	if(Animation_speed>100) {
	            		Animation_speed-=100;
	            		Speed_Text.setText("SPEED: "+(float)Animation_speed/1000+"s");
	            		}
	            } 
	        }; 
	        

	        
			DFS_button.setOnAction(DFSevent);
			BFS_button.setOnAction(BFSevent);
			increase_AnimationTime_button.setOnAction(Slower_Animation);
			deacrease_AnimationTime_button.setOnAction(Faster_Animition);
			
			

	
			pane.getChildren().add(DFS_button);
			pane.getChildren().add(BFS_button);
			pane.getChildren().add(Speed_Text);
			pane.getChildren().add(increase_AnimationTime_button);
			pane.getChildren().add(deacrease_AnimationTime_button);
			Scene scene = new Scene(pane,maze.length*mazeScale,maze[0].length*(mazeScale/2));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

	}
	
	public static void main(String[] args) {
		
		
		for (int i = 0 ; i<maze[0].length; i++) {
			if(maze[0][i]==2) {
				root = new Node(0,i);
				break;
			}
		}
		
		
		int[][] mazeCopy = Arrays.stream(maze).map(int[]::clone).toArray(int[][]::new);
		
		mazeCopy[root.y][root.x]=1;
		setTree(root, mazeCopy);
		
		launch(args);
		

	}
	
	static boolean DFS (Node root) {

		if(root==null)
			return false;
		
		//if(maze_copy2[root.y][root.x]==4)
		//	return false;
		
		//maze_copy2[root.y][root.x]=4;
		System.out.println("DFS [x,y] ="+root.x+" ,"+root.y);

		if(maze[root.y][root.x]==3) {
			
			System.out.println("Reached");
			return true;
		}

		if(maze[root.y][root.x]!=2) {
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(dealyAnimation), evt -> {
	    	rect[root.y][root.x].setFill(Color.BLUE);
	    	rect[root.y][root.x].setStroke(Color.WHITE);
	    	
	    	
				})
			);
			timeline.play();
			dealyAnimation+=Animation_speed;
		}

		
		if(DFS(root.left))
			return true;

		if(DFS(root.down))
			return true;

		if(DFS(root.up))
			return true;
		
		if(DFS(root.right))
			return true;
		
			return false;
	}
	
	void BFS (Node root, int[][] mazeCopy) {
        Queue<Node> q = new LinkedList<Node>();
        if (root != null) q.add(root);
        
        while (!q.isEmpty()) {
        	
        	Node u = q.remove();

            if(mazeCopy[u.y][u.x] == 4)// 4 already Visited
            	continue;
            else
            	mazeCopy[u.y][u.x] = 4;
        	
            if(maze[u.y][u.x]==3) {
    			System.out.println("Reached");
    			return;
    		}
            

            
            if(maze[u.y][u.x]!=2) {
    			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(dealyAnimation), evt -> {
    				    	rect[u.y][u.x].setFill(Color.BLUE);
    				    	rect[u.y][u.x].setStroke(Color.WHITE);
    				    })

    				);
    			timeline.play();
    			dealyAnimation+=Animation_speed;
    		}
    		
            if (u.left != null) q.add(u.left);
            if (u.down != null) q.add(u.down);
            if (u.up != null) q.add(u.up);
            if (u.right != null) q.add(u.right);
        }

		return;
		
			
	}
	
	static void setTree(Node root, int[][] copied_maze) {
		if(root==null)
			return;
		
		//left
		//System.out.println(root.y+" "+root.x);
		if(root.x-1==-1){root.left=null;}
		else if(copied_maze[root.y][root.x-1]==1) {root.left=null;}
		else{
				root.left = new Node(root.y,root.x-1);
				copied_maze[root.y][root.x-1]=1;
		}
		
		//down
		if(root.y+1==copied_maze.length){root.down=null;}
		else if(copied_maze[root.y+1][root.x]==1) {root.down=null;}
		else{
				root.down = new Node(root.y+1,root.x);
				copied_maze[root.y+1][root.x]=1;
		}
		
		//up
		if(root.y-1==-1){root.up=null;}
		else if(copied_maze[root.y-1][root.x]==1) {root.up=null;}
		else{
				root.up = new Node(root.y-1,root.x);
				copied_maze[root.y-1][root.x]=1;
		}
		
		//right
		if(root.x+1==copied_maze[0].length){root.right=null;}
		else if(copied_maze[root.y][root.x+1]==1) {root.right=null;}
		else{
				root.right = new Node(root.y,root.x+1);
				copied_maze[root.y][root.x+1]=1;
		}
		
		int[][] copied_maze_for_left = Arrays.stream(copied_maze).map(int[]::clone).toArray(int[][]::new);
		int[][] copied_maze_for_down = Arrays.stream(copied_maze).map(int[]::clone).toArray(int[][]::new);
		int[][] copied_maze_for_up = Arrays.stream(copied_maze).map(int[]::clone).toArray(int[][]::new);
		int[][] copied_maze_for_right = Arrays.stream(copied_maze).map(int[]::clone).toArray(int[][]::new);
		setTree(root.left, copied_maze_for_left);
		setTree(root.down, copied_maze_for_down);
		setTree(root.up, copied_maze_for_up);
		setTree(root.right, copied_maze_for_right);
		
		return;
	}
	
	void cleanMaze() {
		for (int r = 0 ; r<maze.length; r++) 
			for (int c = 0 ; c<maze[0].length; c++) 
				if(maze[r][c]==0)
					rect[r][c].setFill(Color.WHITE);	
	}
}
