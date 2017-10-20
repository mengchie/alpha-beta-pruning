import java.io.*;
import java.util.*;

public class homework {
	private static long startTime = System.nanoTime();
	private static int maxScore = 0;
	private static int agentScore = 0;

	public static void main(String[] args) throws IOException {
		// genMap(19, 7, 300);
		FileReader in = null;
		char[][] positions;
		char[][] passedP;
		char[][] prePassed;
		char[][] sol;
		int[] index;
        List<String> map = new ArrayList<>();
		int n = 0;
		int p = 0;
		float time = 0;
		int childNum = 0;
		int fruitCounter = 0;
		int depth = 3;
		try {
			in = new FileReader("input.txt");
			BufferedReader br = new BufferedReader(in); 
			String s;
			int line = 0;
	 		while ((s = br.readLine()) != null) {
	 			if(line == 0) {
	 				n = Integer.parseInt(s);
	 			}
	 			if(line == 1) {
	 				p = Integer.parseInt(s);	
	 			}
	 			if(line == 2) {
	 				time = Float.parseFloat(s);
	 			}
	 			if(line > 2) {
	 				map.add(s);
	 			}
	        	line++;
	        }
	        System.out.println(n);
	        System.out.println(p);
	        System.out.println(time);

	        positions = new char[n][n];
	        prePassed = new char[n][n];
	        passedP = new char[n][n];
	        sol = new char[n][n];
	        index = new int[2];

	        for(int i = 0; i < n; i++) {
	        	for(int j = 0; j < n; j++) {
	        		positions[i][j] = map.get(i).charAt(j);
	        		passedP[i][j] = map.get(i).charAt(j);
	        		prePassed[i][j] = map.get(i).charAt(j);
	        		sol[i][j] = map.get(i).charAt(j);
	        	}
	        }

	        
	        
	   //      float myTime = 300;
	   //      boolean alive = true;
	   //      int count = 1;
	   //      int num2 = 0;
	   //      int num3 = 0;
	   //      int num4 = 0;
	   //      int num5 = 0;
	   //      while(alive) {

	   //      	for(int i = 0; i < n; i++) {
		  //       	for(int j = 0; j < n; j++) {
		  //       		positions[i][j] = sol[i][j];
		  //       		passedP[i][j] = sol[i][j];
		  //       		prePassed[i][j] = sol[i][j];
		  //       	}
		  //       }
		  //       int[] agentsc = new int[1];
		  //       minMax(agentsc, index, sol, passedP, positions, n, 0, 1+1, 1+1, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		  //       agentScore += agentsc[0];
		  //       System.out.println("agentScore: " + agentScore);



	   //      	int myChildNum = 0;
	   //      	int myFruitCounter = 0;
	   //      	long myStartTime = System.nanoTime();
	   //      	for(int i = 0; i < n; i++) {
		  //       	for(int j = 0; j < n; j++) {
		  //       		positions[i][j] = sol[i][j];
		  //       		passedP[i][j] = sol[i][j];
		  //       		prePassed[i][j] = sol[i][j];
		  //       	}
		  //       }
	   //      	// calculate childrens number and total number of fruits
		  //       for(int i = 0; i < n; i++) {
		  //       	for(int j = 0; j < n; j++) {
		  //       		if(prePassed[i][j] != '*') {
		  //       			myChildNum++;
		  //       			char[][] newGraph  = new char[n][n];
				// 			myFruitCounter += extend(i, j, prePassed, newGraph, n, prePassed[i][j]);
		  //       		}
		  //       	}
		  //       }
		  //       float fraction = (float)myFruitCounter/(float)myChildNum;

		  //       System.out.println("fruit number: " + myFruitCounter + " , child number: " + myChildNum + " , fraction: " + fraction + " , reciprocal: " + (1/fraction));

		  //       if(myTime < 30) {
		  //       	depth = 2;
		  //       } else {
	   //      		if(myChildNum >= 200) {
			 //        	depth = 2;
			 //        } else if (myChildNum < 150 && fraction > 2.6){
			 //        	depth = 4;
			 //        } else if (myChildNum < 120 && fraction > 2.2){
			 //        	depth = 4;
			 //        } else if (myChildNum < 150 && fraction > 1.8){
			 //        	depth = 3;
			 //        } else {
			 //        	if(myFruitCounter * myChildNum > 100000) {
			 //        		depth = 2;
			 //        	} else if(myFruitCounter * myChildNum <= 55000 && myFruitCounter * myChildNum >= 5000 && myChildNum <= 100) {
			 //        		depth = 4;
			 //        	} else if(myFruitCounter * myChildNum < 6000 && myChildNum < 60){
			 //        		depth = 5;
			 //        	} else {
			 //        		depth = 3;
			 //        	}
			 //        }
		        	
		  //       }
		        
		  //       System.out.println("Depth = " + depth);
		  //       if(depth == 2) {
		  //       	num2++;
		  //       } else if(depth == 3) {
		  //       	num3++;
		  //       } else if(depth == 4) {
		  //       	num4++;
		  //       } else {
		  //       	num5++;
		  //       }
		  //       int[] mysc = new int[1];
		  //       minMax(mysc, index, sol, passedP, positions, n, 0, depth+1, depth+1, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		  //       maxScore += mysc[0];
		  //       long myEndTime = System.nanoTime();

				// for(int i = 0; i < n;i++) {
				// 	for(int j = 0; j < n; j++) {
				// 		System.out.print(sol[i][j]);
				// 	}
				// System.out.println("");
				// }
				// System.out.println("myTime: " + myTime);
				// System.out.println("myScore: " + maxScore);
				// long duration = (myEndTime - myStartTime);
				// myTime = myTime - duration/1000000000;
				// if(myTime < 0) {
				// 	System.out.println("Time out!!!!! You Lose!!!");
				// 	break;
				// }

				// alive = false;
	   //      	for(int i = 0; i < n;i++) {
				// 	for(int j = 0; j < n; j++) {
				// 		if(sol[i][j] != '*') {
				// 			alive = true;
				// 			break;	
				// 		} 
				// 	}
				// 	if(alive == true) break;
				// }
				// if(alive == false) break;

				

		  //       System.out.println("count: " + count);
		  //       count++;
	   //      }

	   //      System.out.println("myScore: " + maxScore + ", agentScore: " + agentScore);
	   //      System.out.println("num2: " + num2 + ", num3: " + num3 + ", num4: " + num4 + ", num5: " + num5);
	   //      System.out.println("remaining time: " + myTime);
	   //      if(maxScore > agentScore) {
	   //      	System.out.println("Win!!!");	
	   //      } else if(maxScore == agentScore) {
	   //      	System.out.println("Tie");
	   //      } else {
	   //      	System.out.println("LOSE !!!");
	   //      }
	        

	        // calculate childrens number and total number of fruits
	        for(int i = 0; i < n; i++) {
	        	for(int j = 0; j < n; j++) {
	        		if(prePassed[i][j] != '*') {
	        			childNum++;
	        			char[][] newGraph  = new char[n][n];
						fruitCounter += extend(i, j, prePassed, newGraph, n, prePassed[i][j]);
	        		}
	        	}
	        }
	        float fraction = (float)fruitCounter/(float)childNum;
	        System.out.println("fruit number: " + fruitCounter + " , child number: " + childNum + " , fraction: " + fraction + " , reciprocal: " + (1/fraction));
	        System.out.println("Time: " + time);

	        if(time < 30) {
	        	depth = 2;
	        } else {
        		if(childNum >= 200) {
		        	depth = 2;
		        } else if (childNum < 150 && fraction > 2.6){
		        	depth = 4;
		        } else if (childNum < 120 && fraction > 2.2){
		        	depth = 4;
		        } else if (childNum < 150 && fraction > 1.8){
		        	depth = 3;
		        } else {
		        	if(fruitCounter * childNum > 100000) {
		        		depth = 2;
		        	} else if(fruitCounter * childNum <= 55000 && fruitCounter * childNum >= 5000 && childNum <= 100) {
		        		depth = 4;
		        	} else if(fruitCounter * childNum < 6000 && childNum < 60){
		        		depth = 5;
		        	} else {
		        		depth = 3;
		        	}
		        }
	        	
	        }
	        System.out.println("Depth: " + depth);
	        
	        int[] sc = new int[1];
	        maxScore = minMax(sc, index, sol, passedP, positions, n, 0, depth+1, depth+1, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
	        System.out.println("My Score: " + sc[0]);

	        // System.out.println(String.valueOf((char)(65 + 0)));
	        // System.out.println(String.valueOf((char)(65 + 1)));


	        System.out.println(maxScore);
	        System.out.println(String.valueOf((char)(65 + index[1])) + index[0]);
	        FileWriter f1 = new FileWriter("output.txt");
	        f1.write(String.valueOf((char)(65 + index[1])));
	        f1.write(index[0] + "\n");
	        for(int i = 0; i < n;i++) {
				for(int j = 0; j < n; j++) {
					f1.write(sol[i][j]);
					System.out.print(sol[i][j]);
				}
				if(i != n-1) {
					f1.write("\n"); 	
				}
				System.out.println("");
			}
			
			f1.close();

			long endTime = System.nanoTime();

			long duration = (endTime - startTime);
			long remain = duration%1000000000;
			System.out.println("duration: " + duration/1000000000 + "s " + remain*1000 + "ms");

		} finally {
	    	if (in != null) {
	    		in.close();
	        }
	    }
	}

	public static int minMax(int[] sc, int[] index, char[][] sol, char[][] passedP, char[][] positions, int n, int minOrMaxScore, int depth, int firstLayer, boolean isMax, int alpha, int beta) {
		boolean isFinished = true;
		List<Child> childList = new ArrayList<Child>();
		

		//set is finished or not
		for(int i = 0; i < n;i++) {
			for(int j = 0; j < n; j++) {
				if(passedP[i][j] != '*') {
					isFinished = false;
					break;	
				} 
			}
			if(isFinished == false) break;
		}

		//terminate condition
		if(isFinished || depth == 0) {
			// System.out.println("At level " + depth + ", and at finished point!!");
			// System.out.println("score: " + s);

			// return s;
			return  minOrMaxScore;
		}

		// get each child and put them into childList
		for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(passedP[i][j] != '*') {
        			char[][] newGraph  = new char[n][n];
        			// deep copy original graph
        			for(int a = 0; a < n; a++) {
			        	for(int b = 0; b < n; b++) {
			        		newGraph[a][b] = positions[a][b];
			        	}
			        }
					int childScore = extend(i, j, passedP, newGraph, n, passedP[i][j]);
					int score = 0;
					if(isMax) {
						score = minOrMaxScore + (childScore * childScore);	
					} else {
						score = minOrMaxScore - (childScore * childScore);	
					}
			        // char[][] childGraph = gravityEffect(newGraph, n);
			        Child child = new Child(score, newGraph, i+1, j);
			     
			        childList.add(child);
        		}
        	}
        }


        if(isMax) {
        	Collections.sort(childList, (Child c1, Child c2) -> c2.score - c1.score);	
        } else {
        	Collections.sort(childList, (Child c1, Child c2) -> c1.score - c2.score);	
        }

		if(isMax == true) {
			int v = Integer.MIN_VALUE;

			for(int i = 0; i < childList.size(); i++) {
				char[][] newGraph = childList.get(i).map;
				int score = childList.get(i).score;
				int row = childList.get(i).row;
				int col = childList.get(i).col;

				char[][] childGraph = gravityEffect(newGraph, n);
		        //childPassedP is prepare for passing into recusion
		        char[][] childPassedP = new char[n][n];
		        for(int a = 0; a < n; a++) {
		        	for(int b = 0; b < n; b++) {
		        		childPassedP[a][b] = childGraph[a][b];
		        	}
		        }
		        int childValue = minMax(sc, index, sol, childPassedP, childGraph, n, score, depth - 1, firstLayer, false, alpha, beta);
		        
		        if(depth == firstLayer && childValue > v) {
		        	index[0] = row;
		        	index[1] = col;
		        	for(int a = 0; a < n;a++) {
						for(int b = 0; b < n; b++) {
							sol[a][b] = childGraph[a][b];
						}
					}
					sc[0] = score;
		        }
		        v = Math.max(v, childValue);
		        alpha = Math.max(alpha, v);
		        if(beta <= alpha) {
		        	// System.out.println("pruning at MAX, at level " + depth);
		        	break;
		        }
			}
	        return v;
		} else {
			int v = Integer.MAX_VALUE;

			for(int i = 0; i < childList.size(); i++) {
				char[][] newGraph = childList.get(i).map;
				int score = childList.get(i).score;

				char[][] childGraph = gravityEffect(newGraph, n);

		        //childPassedP is prepare for passing into recusion
		        char[][] childPassedP = new char[n][n];
		        for(int a = 0; a < n; a++) {
		        	for(int b = 0; b < n; b++) {
		        		childPassedP[a][b] = childGraph[a][b];
		        	}
		        }
		       	v = Math.min(v, minMax(sc, index, sol, childPassedP, childGraph, n, score, depth - 1, firstLayer, true, alpha, beta));
		        beta = Math.min(beta, v);
		        if(beta <= alpha) {
		        	// System.out.println("pruning at MIN, at level " + depth);
		        	break;
		        }
			}
	        return v;
		}
	}

	public static int extend(int row, int col, char[][] passedP, char[][] newGraph, int n, char fruit) {
		passedP[row][col] = '*';
		newGraph[row][col] = '*';
		int score = 0;

		if(row+1 < n && passedP[row+1][col] == fruit) {
			score += extend(row+1, col, passedP, newGraph, n, fruit);
		}

		if(row-1 >= 0 && passedP[row-1][col] == fruit) {
			score += extend(row-1, col, passedP, newGraph, n, fruit);
		}

		if(col+1 < n && passedP[row][col+1] == fruit) {
			score += extend(row, col+1, passedP, newGraph, n, fruit);
		}

		if(col-1 >= 0 && passedP[row][col-1] == fruit) {
			score += extend(row, col-1, passedP, newGraph, n, fruit);
		}
		score += 1;
		return score;
	}

	public static char[][] gravityEffect (char[][] passedP, int n) {
		char[][] gravity = new char[n][n];
		int[] starNum = new int[n];
		//deep copy of passedP to gravity array
		for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		gravity[i][j] = passedP[i][j];
        		if(passedP[j][i] == '*') {
        			starNum[i] += 1;
        		}
        	}
        }

        for(int col = 0; col < n; col++) {
        	int fruitNum = n - starNum[col];
        	if(starNum[col] > 0) {
        		int pRow = n - 1;
        		int gRow = n - 1;
        		while(fruitNum > 0) {
        			if(passedP[pRow][col] != '*') {
        				gravity[gRow][col] = passedP[pRow][col];
	        			fruitNum--;
	        			pRow--;
	        			gRow--;
	        		} else {
	        			pRow--;
	        		}
        		}
        		while(gRow >= 0) {
        			gravity[gRow][col] = '*';
        			gRow--;
        		}
        	} 
        	
        }

		return gravity;
	}
	public static void genMap(int n, int p, int t) {
	  Random random = new Random();
	  try {
	   BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("input.txt"), "utf-8"));
	   StringBuilder sb = new StringBuilder();
	   sb.append(n + "\n");
	   sb.append(p + "\n");
	   sb.append(t + "\n");
	   for (int i = 0; i < n; i++) {
	    for (int j = 0; j < n; j++) {
	     sb.append((char)(random.nextInt(p) + '0'));
	    }
	    if (i != n - 1)
	    sb.append("\n");
	   }

	   System.out.println("Initial Map");
	   System.out.println(sb.toString());
	   bw.write(sb.toString());
	   bw.close();
	   
	  } catch (UnsupportedEncodingException e) {
	   e.printStackTrace();
	  } catch (FileNotFoundException e) {
	   e.printStackTrace();
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	 }

	public static class Child {
		public int score;
		public char[][] map;
		public int row;
		public int col;
		public Child(int score, char[][] map, int row, int col) {
			this.score = score;
			this.map = map;
			this.row = row;
			this.col = col;
		}
	}
}

