package application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class SceneController {


	@FXML
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	public GridPane gridPane;
	@FXML
	public Text turnk;
	@FXML
	public Text turnzero;



	
	static int counter = 0;
	static int decider = 0;

	//if it stays 0, the 2 player mode is initiated, if it turns to 1, the randomizer is activated
	
	
	public int[][] matrix = {
			{0,0,0},
			{0,0,0},
			{0,0,0}
	};

public void turns() {
	
	if(counter == 0 ) {
		this.turnk.setVisible(true);
		this.turnzero.setVisible(false);
	}
	
	if(counter % 2 == 0) {
		this.turnk.setVisible(true);
		this.turnzero.setVisible(false);
	}else {
		this.turnk.setVisible(false);
		this.turnzero.setVisible(true);
	}
	
	
}

	
	public boolean check() {
		
		
		System.out.println("Matrix is: " + matrix[0][0] + "  " + matrix[0][1] + " " + matrix[0][2]);
		System.out.println("Matrix is: " + matrix[1][0] + "  " + matrix[1][1] + " " + matrix[1][2]);
		System.out.println("Matrix is: " + matrix[2][0] + "  " + matrix[2][1] + " " + matrix[2][2]);
	
	    for (int i = 0; i < 3; i++) {
	     
	        if (this.matrix[i][0] == this.matrix[i][1] && this.matrix[i][1] == this.matrix[i][2] && this.matrix[i][0] == 1) {
	            return true; //k
	        }
	        if (this.matrix[i][0] == this.matrix[i][1] && this.matrix[i][1] == this.matrix[i][2] && this.matrix[i][0] == 2) {
	            return true; //0
	        }
	    
	        if (this.matrix[0][i] == this.matrix[1][i] && this.matrix[1][i] == this.matrix[2][i] && this.matrix[0][i] == 1) {
	            return true; //0
	        }
	        if (this.matrix[0][i] == this.matrix[1][i] && this.matrix[1][i] == this.matrix[2][i] && this.matrix[0][i] == 2) {
	            return true; //k
	        }
	    }

	 
	    if (this.matrix[0][0] == this.matrix[1][1] && this.matrix[1][1] == this.matrix[2][2] && this.matrix[0][0] == 1) {
	        return true; //k
	    }
	    if (this.matrix[0][0] == this.matrix[1][1] && this.matrix[1][1] == this.matrix[2][2] && this.matrix[0][0] == 2) {
	        return true; //0
	    }
	    if (this.matrix[0][2] == this.matrix[1][1] && this.matrix[1][1] == this.matrix[2][0] && this.matrix[0][2] == 1) {
	        return true; //k
	    }
	    if (this.matrix[0][2] == this.matrix[1][1] && this.matrix[1][1] == this.matrix[2][0] && this.matrix[0][2] == 2) {
	        return true; //0
	    }

	    return false; 
	}
	
	public void switchToScenePlayerOne(ActionEvent event) throws IOException {

	    decider = 1;

        Parent root = FXMLLoader.load(getClass().getResource("player1Scene.fxml"));
        
        System.out.println("Initiated 1 player mode successfully! ");
        
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
  
        scene = new Scene(root);

        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        

        stage.show();
	
	}
	public void switchToScenePlayerTwo(ActionEvent event) throws IOException {
		decider = 0;
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("player2scne.fxml"));
	    Parent root = loader.load();
	    
	   //important
	    SceneController controller = loader.getController();
	    
	 
	    controller.turnk.setVisible(true);
	    controller.turnzero.setVisible(false);
      //important
	    
	    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    scene = new Scene(root);
	    stage.setScene(scene);
	    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    stage.show();
	}
	public void switchToMainTitle(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("text.fxml"));
		
	        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	       
	      
	 	  
	        scene = new Scene(root);

	        stage.setScene(scene);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	        stage.show();
	        SceneController.counter = 0;
		
	}
	
	public void switchToWinnerK(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("switchToWinnerK.fxml"));
		
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
      
 	  
        scene = new Scene(root);

        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        stage.show();
	}
	public void switchToWinnerZero(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("switchToWinnerZero.fxml"));
		
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
      
 	  
        scene = new Scene(root);

        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        stage.show();
	}

	 public void addImageToGrid(String name, int x, int y) {
		
		 
	        Image image = new Image(getClass().getResourceAsStream("kimage.png"));
	        try (InputStream input = getClass().getResourceAsStream(name)) {
	            if (input == null) {
	                System.err.println("Image resource not found: " + name);
	                return; 
	            }
	            image = new Image(input);
	        } catch (IOException e) {
	            System.err.println("Error loading image: " + e.getMessage());
	        }

	        ImageView imageView = new ImageView(image);
	        
	        imageView.setFitWidth(100);  
	        imageView.setFitHeight(100); 
	        imageView.setPreserveRatio(true); 
	        this.gridPane.add(imageView, x, y); 
	    }


	public void playingButton11(ActionEvent event) throws IOException {

        Random random = new Random();
		int xx = random.nextInt(3);
		int yy = random.nextInt(3);

		if(this.matrix[0][0] == 0) {
			if(counter % 2 == 0) {
				
			    this.matrix[0][0] = 1;
				if(decider == 1){
					this.matrix[xx][yy] = 2;
				}

			    } else
			    {
			    	this.matrix[0][0] = 2;
					if(decider == 1){
						this.matrix[xx][yy] = 1;
					}

			    }

	    if (check()) {
	    	
	    	if(counter % 2 == 0) {
	    		 System.out.println("Player 1 wins! (K)");
	    		
	    		    switchToWinnerK(event); 
	    	}else {
	    		System.out.println("Player 2 wins!(0)");
	    	        switchToWinnerZero(event);
	    	}   
	    }
	    
	    
	    if (counter % 2 == 0) {
	        addImageToGrid("kimage.png", 0, 0);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("zeroimage.png", xx, yy);
				}else
					addImageToGrid("zeroimage.png", random.nextInt(3), random.nextInt(3));

			}
	    } else {
	        addImageToGrid("zeroimage.png", 0, 0);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("kimage.png", xx, yy);
				}else
					addImageToGrid("kimage.png", random.nextInt(3), random.nextInt(3));
			}
	    }
	    counter++;
	    System.out.println("Button initiated successfully!");
	    turns();}
		else
			System.out.println("Spot taken");
		
	 
	}


	public void playingButton12(ActionEvent event) throws IOException {

		Random random = new Random();
		int xx = random.nextInt(3);
		int yy = random.nextInt(3);


		if(this.matrix[0][1] == 0) {
			if(counter % 2 == 0) {
				
			    this.matrix[0][1] = 1;

				if(decider == 1){
					this.matrix[xx][yy] = 2;
				}
			    
			    } else
			    {
			    	this.matrix[0][1] = 2;
					if(decider == 1){
						this.matrix[xx][yy] = 1;
					}

			    }
		
	    if (check()) {
	    	
	    	if(counter % 2 == 0) {
	    		 System.out.println("Player 1 wins! (K)");
	    		
	    		    switchToWinnerK(event); 
	    	}else {
	    		System.out.println("Player 2 wins!(0)");
	    		 switchToWinnerZero(event);
	    	}   
	    }
	  

	    if (counter % 2 == 0) {
	        addImageToGrid("kimage.png", 1, 0);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("zeroimage.png", xx, yy);
				}else
					addImageToGrid("zeroimage.png", random.nextInt(3), random.nextInt(3));
			}
	    } else {
	        addImageToGrid("zeroimage.png", 1, 0);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("kimage.png", xx, yy);
				}else
					addImageToGrid("kimage.png", random.nextInt(3), random.nextInt(3));
			}
	    }
	    counter++;
	    

	    System.out.println("Button initiated successfully!");
	    turns();}
		else
			System.out.println("Spot taken");
		
		
	}


	public void playingButton13(ActionEvent event) throws IOException {
		Random random = new Random();
		int xx = random.nextInt(3);
		int yy = random.nextInt(3);

		if(this.matrix[0][2] == 0) {
			if(counter % 2 == 0) {
				
			    this.matrix[0][2] = 1;
				if(decider == 1){
					this.matrix[xx][yy] = 2;
				}
			    
			    } else
			    {
			    	this.matrix[0][2] = 2;
					if(decider == 1){
						this.matrix[xx][yy] = 1;
					}
			    }
		
	    if (check()) {
	    	
	    	if(counter % 2 == 0) {
	    		 System.out.println("Player 1 wins! (K)");
	    		
	    		    switchToWinnerK(event); 
	    	}else {
	    		System.out.println("Player 2 wins!(0)");
	    		 switchToWinnerZero(event);
	    	}   
	    }
	   
	    
	    if (counter % 2 == 0) {
	        addImageToGrid("kimage.png", 2, 0);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("zeroimage.png", xx, yy);
				}else
					addImageToGrid("zeroimage.png", random.nextInt(3), random.nextInt(3));
			}
	    } else {
	        addImageToGrid("zeroimage.png", 2, 0);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("kimage.png", xx, yy);
				}else
					addImageToGrid("kimage.png", random.nextInt(3), random.nextInt(3));
			}
	    }
	    counter++;

	    
	    System.out.println("Button initiated successfully!");
	    turns();}
		else
			System.out.println("Spot taken");

		
	}

	
	public void playingButton21(ActionEvent event) throws IOException {

		Random random = new Random();
		int xx = random.nextInt(3);
		int yy = random.nextInt(3);

		if(this.matrix[1][0] == 0) {
			if(counter % 2 == 0) {
				
			    this.matrix[1][0] = 1;
				if(decider == 1){
					this.matrix[xx][yy] = 2;
				}
			    } else
			    {
			    	this.matrix[1][0] = 2;
					if(decider == 1){
						this.matrix[xx][yy] = 1;
					}
			    }
		
	    if (check()) {
	    	
	    	if(counter % 2 == 0) {
	    		 System.out.println("Player 1 wins! (K)");
	    	
	    		    switchToWinnerK(event);
	    	}else {
	    		System.out.println("Player 2 wins!(0)");
	    		 switchToWinnerZero(event);
	    	}   
	    }
	    
	    if (counter % 2 == 0) {
	        addImageToGrid("kimage.png", 0, 1);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("zeroimage.png", xx, yy);
				}else
					addImageToGrid("zeroimage.png", random.nextInt(3), random.nextInt(3));
			}
	    } else {
	        addImageToGrid("zeroimage.png", 0, 1);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("kimage.png", xx, yy);
				}else
					addImageToGrid("kimage.png", random.nextInt(3), random.nextInt(3));
			}
	    }
	    counter++;
	    
	    
	   
	    System.out.println("Button initiated successfully!");
	    turns();}
		else
			System.out.println("Spot taken");
		
		
	
	}


	public void playingButton22(ActionEvent event) throws IOException {
		Random random = new Random();
		int xx = random.nextInt(3);
		int yy = random.nextInt(3);

		if(this.matrix[1][1] == 0) {
			if(counter % 2 == 0) {
				
			    this.matrix[1][1] = 1;
				if(decider == 1){
					this.matrix[xx][yy] = 2;
				}
			    
			    } else
			    {
			    	this.matrix[1][1] = 2;
					if(decider == 1){
						this.matrix[xx][yy] = 1;
					}
			    }
		
	    if (check()) {
	    	
	    	if(counter % 2 == 0) {
	    		 System.out.println("Player 1 wins! (K)");
	    		
	    		    switchToWinnerK(event); 
	    	}else {
	    		System.out.println("Player 2 wins!(0)");
	    		 switchToWinnerZero(event);
	    	}   
	    }
	    if (counter % 2 == 0) {
	        addImageToGrid("kimage.png", 1, 1);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("zeroimage.png", xx, yy);
				}else
					addImageToGrid("zeroimage.png", random.nextInt(3), random.nextInt(3));
			}
	    } else {
	        addImageToGrid("zeroimage.png", 1, 1);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("kimage.png", xx, yy);
				}else
					addImageToGrid("kimage.png", random.nextInt(3), random.nextInt(3));
			}
	    }
	    counter++;
	    System.out.println("Button initiated successfully!");
	    turns();}
		else
			System.out.println("Spot taken");
		
		
	
		
	}

	
	
	
	
	
	
	
	public void playingButton23(ActionEvent event) throws IOException {
		Random random = new Random();
		int xx = random.nextInt(3);
		int yy = random.nextInt(3);
		if(this.matrix[1][2] == 0) {
			if(counter % 2 == 0) {
				
			    this.matrix[1][2] = 1;
				if(decider == 1){
					this.matrix[xx][yy] = 2;
				}
			    
			    } else
			    {
			    	this.matrix[1][2] = 2;
					if(decider == 1){
						this.matrix[xx][yy] = 1;
					}
			    }
		
		
	    if (check()) {
	    	
	    	if(counter % 2 == 0) {
	    		 System.out.println("Player 1 wins! (K)");
	    		
	    		    switchToWinnerK(event); 
	    	}else {
	    		System.out.println("Player 2 wins!(0)");
	    		 switchToWinnerZero(event);
	    	}   
	    }
	  
   
	    
	    if (counter % 2 == 0) {
	        addImageToGrid("kimage.png", 2, 1);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("zeroimage.png", xx, yy);
				}else
					addImageToGrid("zeroimage.png", random.nextInt(3), random.nextInt(3));
			}
	    } else {
	        addImageToGrid("zeroimage.png", 2, 1);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("kimage.png", xx, yy);
				}else
					addImageToGrid("kimage.png", random.nextInt(3), random.nextInt(3));
			}
	    }
	    counter++;
	    

	    System.out.println("Button initiated successfully!");
	    turns();}
		else
			System.out.println("Spot taken");
		
		
	}

	
	
	
	
	
	
	
	public void playingButton31(ActionEvent event) throws IOException {
		Random random = new Random();
		int xx = random.nextInt(3);
		int yy = random.nextInt(3);
		if(this.matrix[2][0] == 0) {
			if(counter % 2 == 0) {
				
			    this.matrix[2][0] = 1;
				if(decider == 1){
					this.matrix[xx][yy] = 2;
				}
			    
			    } else
			    {
			    	this.matrix[2][0] = 2;
					if(decider == 1){
						this.matrix[xx][yy] = 1;
					}
			    }
		
	    if (check()) {
	    	
	    	if(counter % 2 == 0) {
	    		 System.out.println("Player 1 wins! (K)");
	    		
	    		    switchToWinnerK(event); 
	    	}else {
	    		System.out.println("Player 2 wins!(0)");
	    		 switchToWinnerZero(event);
	    	}   
	    }
	    
	    if (counter % 2 == 0) {
	        addImageToGrid("kimage.png", 0, 2);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("zeroimage.png", xx, yy);
				}else
					addImageToGrid("zeroimage.png", random.nextInt(3), random.nextInt(3));
			}
	    } else {
	        addImageToGrid("zeroimage.png", 0, 2);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("kimage.png", xx, yy);
				}else
					addImageToGrid("kimage.png", random.nextInt(3), random.nextInt(3));
			}
	    }
	    counter++;
	    
	    
	  
	    System.out.println("Button initiated successfully!");
	    turns();}
		else
			System.out.println("Spot taken");
		
		

	}


	public void playingButton32(ActionEvent event) throws IOException {
		Random random = new Random();
		int xx = random.nextInt(3);
		int yy = random.nextInt(3);
		if(this.matrix[2][1] == 0) {
			if(counter % 2 == 0) {
				
			    this.matrix[2][1] = 1;
				if(decider == 1){
					this.matrix[xx][yy] = 2;
				}
			    
			    } else
			    {
			    	this.matrix[2][1] = 2;
					if(decider == 1){
						this.matrix[xx][yy] = 1;
					}
			    }
		
	    if (check()) {
	    	
	    	if(counter % 2 == 0) {
	    		 System.out.println("Player 1 wins! (K)");
	    	
	    		    switchToWinnerK(event); 
	    	}else {
	    		System.out.println("Player 2 wins!(0)");
	    		 switchToWinnerZero(event);
	    	}   
	    }
	    
	    if (counter % 2 == 0) {
	        addImageToGrid("kimage.png", 1, 2);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("zeroimage.png", xx, yy);
				}else
					addImageToGrid("zeroimage.png", random.nextInt(3), random.nextInt(3));
			}
	    } else {
	        addImageToGrid("zeroimage.png", 1, 2);
			if(decider ==1){

				if(this.matrix[xx][yy] == 0){
					addImageToGrid("kimage.png", xx, yy);
				}else
					addImageToGrid("kimage.png", random.nextInt(3), random.nextInt(3));
			}
	    }
	    counter++;
	    
	 
	    System.out.println("Button initiated successfully!");
	    turns();}
		else
			System.out.println("Spot taken");
		

	}

	
	
	
	
	
	
	public void playingButton33(ActionEvent event) throws IOException {
		Random random = new Random();
		int xx = random.nextInt(3);
		int yy = random.nextInt(3);
		if(this.matrix[2][2] == 0) {
			if(counter % 2 == 0) {
				
			    this.matrix[2][2] = 1;
				if(decider == 1){
					this.matrix[xx][yy] = 2;
				}
			    
			    } else
			    {
			    	this.matrix[2][2] = 2;
					if(decider == 1){
						this.matrix[xx][yy] = 1;
					}
			    }
		
		
	    if (check()) {
	    	
	    	if(counter % 2 == 0) {
	    		 System.out.println("Player 1 wins! (K)");
	    		
	    		    switchToWinnerK(event); 
	    	}else {
	    		System.out.println("Player 2 wins!(0)");
	    		 switchToWinnerZero(event);
	    	}   
	    }

		 if (counter % 2 == 0) {
		        addImageToGrid("kimage.png", 2, 2);
			 if(decider ==1){

				 if(this.matrix[xx][yy] == 0){
					 addImageToGrid("zeroimage.png", xx, yy);
				 }else
					 addImageToGrid("zeroimage.png", random.nextInt(3), random.nextInt(3));
			 }
		    } else {
		        addImageToGrid("zeroimage.png", 2, 2);
			 if(decider ==1){

				 if(this.matrix[xx][yy] == 0){
					 addImageToGrid("kimage.png", xx, yy);
				 }else
					 addImageToGrid("kimage.png", random.nextInt(3), random.nextInt(3));
			 }
		    }
		    counter++;

	    System.out.println("Button initiated successfully!");
	  turns();
	    
		}else
			System.out.println("Spot already taken! ");

	    
	}
}