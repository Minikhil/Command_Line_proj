package cse410_proj1;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.Scanner;

public class generator {
	
	private static Integer integer;

	public static boolean isStringInt(String s)
	{
	    try
	    {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}

	public static void main(String[] args) {
		
		
		
		
		// TODO Auto-generated method stub
		boolean outPutFileReq = false; 
		boolean outPutFileExist = false; 
		PrintWriter writer = null;
		String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		String[] loremWords = lorem.split(" ");
		String anguish = "Pitter Paper peeked or parker peckled paupers. Or packer peckled paupers pitter paper peeked. Aft Pitter Paper peeked or packer peckled paupers. Ware aster packer peckled paupers debt pitter paper peeked?";
		String[] anguishWords = anguish.split(" ");
		String textSrc = null;
		String format = null;
		int countParagraphs = 1;
		int countWords = 3;
		int countBullets = 5;
		boolean htmlReq = false;
		boolean cmdLineMode = false;
		String[] IntModearr;
		
		java.util.List<String> arr = Arrays.asList(args);
		
		//check for -h -v -o
			if(arr.contains("--generate") ||arr.contains("-g") ) {
				cmdLineMode = true;
				System.out.println("------------------------Command Line Mode-----------------------------------------");
			}
			
			
			if(cmdLineMode) {
			
			if (arr.contains("--help") || arr.contains("-h") ) {
				if(arr.size()==1) {
					System.out.println("HELP MENU");
					System.out.println("A star (*) in the description means that the command is standalone. ");
					System.out.println("------------------------------------------------------------------------ ");
					System.out.println("COMMAND LINE MODE: ");
					System.out.println("------------------------------------------------------------------------- ");
					System.out.println("--help, -h: * List the various options and the way in which command can be used  ");
					System.out.println("--version, -v: * Displays the version number of your program  ");
					System.out.println("--library, -l: ");
					System.out.println("--outfile, -o: ");
					System.out.println("--mode, -m <mode>: ");
					System.out.println("--count, -c <count>: ");
					System.out.println("--html, -t: ");
					System.out.println("--generate, -g: ");
					System.out.println("-------------------------------------------------------------------------- ");
					System.out.println("INTERACTIVE MODE: ");
					System.out.println("-------------------------------------------------------------------------- ");
					System.out.println("help: As in command line mode");
					System.out.println("version: As in command line mode");
					System.out.println("set <option> <value>:");
					System.out.println("show <option> <value>:");
					System.out.println("exit or quit:");
				}
				else {
					System.out.println("help is only valid as a stand-alone option");
					System.exit(0); //Exits the loop
				}
				
		
			}//END OF HELP CONDITION
			if (arr.contains("--version") || arr.contains("-v") ) {
				if(arr.size()==1) {
					System.out.println("Version:1.0 ");
				}
				else {
					System.out.println("version is only valid as a stand-alone option");
					System.exit(0); //Exits the loop
				}
			}//END OF VERSION CONDITION
			
			if(arr.contains("--outfile") || arr.contains("-o")){
				outPutFileReq = true;
				int index = 0;
				if(arr.contains("--outfile")) {
					index = arr.indexOf("--outfile");
				}
				else {
					index = arr.indexOf("-o");
				}
				String fileName = arr.get(index+1);
				
				
				try {
					
			         // create new files
					File f = new File(fileName); 
				
			         
			         // tests if file exists
			         outPutFileExist = f.exists();
			         
			         // prints
			         System.out.println("File exists: "+outPutFileExist);
			         
			         if(outPutFileExist == true) {
			        
			            System.out.println("Error: File already exist");
			            System.exit(0); //Exists the loop
			         }
			         else {
			        		
					         // create new file in the system
					         f.createNewFile();
					         System.out.println("File created:"+ fileName);
					         
			         }
			         
			         
			         
			      } catch(Exception e) {
			         // if any error occurs
			         e.printStackTrace();
			      }
				
				try {
					writer = new PrintWriter(fileName); //overwrites file if already exist else creates file 
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 		
				
			}//END OF OUTFILE CONDITION
			
			if(arr.contains("--count") || arr.contains("-c")){
				int index = 0;
				int countNum= 0;
				
				if(arr.contains("--count")) {
					index = arr.indexOf("--count");
				}
				else if (arr.contains("-c")) {
					index = arr.indexOf("-c");
				}
				
				//System.out.println("index +1: " + (index+1) + "args.len:" + args.length);
				//checks if the the arg after count is an Integer
				if((index+1) < args.length) {
					if(isStringInt(args[index+1])) {
						 countNum = Integer.parseInt(args[index+1]);
						 if(arr.contains("paragraphs")) {
							 countParagraphs = countNum;
							System.out.println("countParagraphs: " + countParagraphs);
							
						}
						else if(arr.contains("words")) {
							countWords = countNum;
							System.out.println("countWords: " + countWords);
						}
						else if(arr.contains("bullets")) {
							countBullets = countNum;
							System.out.println("countBullets: " + countNum);
						}
					}
				}
				
				
		
				
				
				else {
					System.out.println("COUNT ERROR");
				}
				
				
				
			}//END OF COUNT CONDITION
			
			if (arr.contains("--html") || arr.contains("-t") ) { htmlReq = true; }//END OF HTML CONDITION
		
		//START OF LOOP
		for (int i =0; i < arr.size(); i++) {
			
			if(arr.get(i).equals("--library") || arr.get(i).equals("-l")){
				textSrc = arr.get(i+1);
				if(textSrc.equals("lorem")){
					if(outPutFileReq) {
						writer.println("https://www.lipsum.com/");
					}
					else {
						System.out.println( "https://www.lipsum.com/");
					}
					
				}
				else if(textSrc.equals("anguish")){
					if(outPutFileReq) {
						writer.println("https://www.crockford.com/wrrrld/anguish.html");
					}
					else {
						System.out.println("https://www.crockford.com/wrrrld/anguish.html");
					}
				}
				else {
					System.out.println("Error library name not valid or selected, please state valid name after library option. Valid names include : 1) lorem 2) anguishh");
				}
				
			}//END OF LIB CONDITION
			
			if(arr.get(i).equals("--mode") || arr.get(i).equals("-m")){
				if(i+1<arr.size()) {
					
				
				if(arr.get(i+1).equals("paragraphs")){
					if(outPutFileReq) {
						if(textSrc.equals("lorem")) {
		
							int counter2 = Math.round((loremWords.length)/countParagraphs);
							if(loremWords.length % 2 != 0) {
								counter2++;
							}
							
							int counterDeno = 1;
							int start = 0;
							
							//System.out.println("loremWords: " + loremWords.length + "Counter2: " + counter2);
							
							
							while(start < loremWords.length) {
								//System.out.println("in loop start:" + start);
								String[] array1= Arrays.copyOfRange(loremWords, start, counter2*counterDeno);
								//System.out.println("new array created");
								start = (counter2*counterDeno);
								counterDeno++;
								//System.out.println("start changed:" + start);
								
								
								for(int j =0; j< array1.length; j++) {
									if(htmlReq & j==0 ) {
										writer.print("<p>");
									}
									
									if(j!=0 & j % 6 == 0 & array1[j]!= null) {//skip to next line
									
								
										
										writer.println(array1[j]+ " ");
										//writer.print("SKIP TO NEXT LINE");
									}
									
									else{ //print on same line
										if(array1[j]!= null & j+1!= array1.length) {
											writer.print(array1[j]+ " ");
											
										}
										else if(array1[j]!= null & j+1==array1.length) {
											writer.print(array1[j]);
										}
										
								
									}
								}
								if(htmlReq) {
									writer.print("</p>");
								}
								
								
								writer.println("\n");
								
								
								
							 
							}
			
							
						}
						else if(textSrc.equals("anguish")) {
							int counter2 = Math.round((anguishWords.length)/countParagraphs);
							if(anguishWords.length % 2 != 0) {
								counter2++;
							}
							
							int counterDeno = 1;
							int start = 0;
							System.out.println("anguishWords: " + anguishWords.length + "Counter2: " + counter2);
							
							
							
							
							while(start < anguishWords.length) {
								System.out.println("in loop start:" + start);
								String[] array1= Arrays.copyOfRange(anguishWords, start, counter2*counterDeno);
								System.out.println("new array created");
								start = (counter2*counterDeno);
								counterDeno++;
								System.out.println("start changed:" + start);
								
								
								for(int j =0; j< array1.length; j++) {
									if(htmlReq & j==0 ) {
										writer.print("<p>");
									}
									if(j!=0 & j % 6 == 0 & array1[j]!= null) {//skip to next line
									
										
										writer.println(array1[j]+ " ");
										//writer.print("SKIP TO NEXT LINE");
									}
									
									else{ //print on same line
										if(array1[j]!= null) {
											writer.print(array1[j]+ " ");
											
										}
										
								
									}
								}
								if(htmlReq) {
									writer.print("</p>");
								}
								
								writer.println("\n");
								
								
								
							 
							}
						}
						
					}
					else if(!outPutFileReq) { //PRINT OUT IN CONSOLE
						if(textSrc.equals("lorem")) {
							
							int counter2 = Math.round((loremWords.length)/countParagraphs);
							if(loremWords.length % 2 != 0) {
								counter2++;
							}
							
							int counterDeno = 1;
							int start = 0;
							
							//System.out.println("loremWords: " + loremWords.length + "Counter2: " + counter2);
							
							
							while(start < loremWords.length) {
								//System.out.println("in loop start:" + start);
								String[] array1= Arrays.copyOfRange(loremWords, start, counter2*counterDeno);
								//System.out.println("new array created");
								start = (counter2*counterDeno);
								counterDeno++;
								//System.out.println("start changed:" + start);
								
								
								for(int j =0; j< array1.length; j++) {
									if(htmlReq & j==0 ) {
										System.out.print("<p>");
									}
									
									if(j!=0 & j % 6 == 0 & array1[j]!= null) {//skip to next line
									
								
										
										System.out.println(array1[j]+ " ");
										//writer.print("SKIP TO NEXT LINE");
									}
									
									else{ //print on same line
										if(array1[j]!= null & j+1!= array1.length) {
											System.out.print(array1[j]+ " ");
											
										}
										else if(array1[j]!= null & j+1==array1.length) {
											System.out.print(array1[j]);
										}
										
								
									}
								}
								if(htmlReq) {
									System.out.print("</p>");
								}
								
								
								System.out.println("\n");
								
								
								
							 
							}
			
							
						}
						else if(textSrc.equals("anguish")) {
							int counter2 = Math.round((anguishWords.length)/countParagraphs);
							if(anguishWords.length % 2 != 0) {
								counter2++;
							}
							
							int counterDeno = 1;
							int start = 0;
							//System.out.println("anguishWords: " + anguishWords.length + "Counter2: " + counter2);
							
							
							
							
							while(start < anguishWords.length) {
								//System.out.println("in loop start:" + start);
								String[] array1= Arrays.copyOfRange(anguishWords, start, counter2*counterDeno);
								//System.out.println("new array created");
								start = (counter2*counterDeno);
								counterDeno++;
								//System.out.println("start changed:" + start);
								
								
								for(int j =0; j< array1.length; j++) {
									if(htmlReq & j==0 ) {
										System.out.print("<p>");
									}
									
									if(j!=0 & j % 6 == 0 & array1[j]!= null) {//skip to next line
									
										
										System.out.println(array1[j]+ " ");
										//writer.print("SKIP TO NEXT LINE");
									}
									
									else{ //print on same line
										if(array1[j]!= null & j+1!= array1.length) {
											System.out.print(array1[j]+ " ");
											
										}
										else if(array1[j]!= null & j+1==array1.length) {
											System.out.print(array1[j]);
										}
										
								
									}
								}
								if(htmlReq) {
									System.out.print("</p>");
								}
								
								System.out.println("\n");
								
								
								
							 
							}
						}
						
						
					}
					
				}//END OF MODE PARAGRAGH 
				else if(arr.get(i+1).equals("words")){
					
					if(outPutFileReq) {
						if(textSrc.equals("lorem")) {
							if(countWords > loremWords.length) {
								System.out.println("Count value exceeds the word count of text, please enter valid word count");
							}
							else {
								
								for(int j =0; j< countWords; j++) {
									if(htmlReq) {
										writer.println("<h1>" + loremWords[j] + "</h1>");
									}
									else {
										writer.println(loremWords[j]);
									}
									
									
								}
								
							}
							
						}
						else if(textSrc.equals("anguish")) {
							if(countWords > anguishWords.length) {
								System.out.println("Count value exceeds the word count of text, please enter valid word count");
							}
							else {
								for(int j =0; j< countWords; j++) {
									if(htmlReq) {
										writer.println("<h1>" + anguishWords[j] + "</h1>");
									}
									else {
										writer.println(anguishWords[j]);
									}
									
								}
							}
							
						}
						
						
						
					}
					else {
						if(textSrc.equals("lorem")) {
							if(countWords > loremWords.length) {
								System.out.println("Count value exceeds the word count of text, please enter valid word count");
							}
							else {
								for(int j =0; j< countWords; j++) {
									if(htmlReq) {
										System.out.println("<h1>" + loremWords[j] + "</h1>");
									}
									else {
										System.out.println(loremWords[j]);
									}
									
									
								}
							}
							
						}
						else if(textSrc.equals("anguish")) {
							if(countWords > anguishWords.length) {
								System.out.println("Count value exceeds the word count of text, please enter valid word count");
							}
							else {
								for(int j =0; j< countWords; j++) {
									if(htmlReq) {
										System.out.println("<h1>" + anguishWords[j] + "</h1>");
									}
									else {
										System.out.println(anguishWords[j]);
									}
									
								}
							}
							
						}
						
					}
				}//END OF MODE WORDS
				else if(arr.get(i+1).equals("bullets")){
					if(outPutFileReq) {
						if(textSrc.equals("lorem")) {
							if(htmlReq) {
								writer.println("<ul>");
							}
							for(int j =0; j< countBullets; j++) {
								if(htmlReq) {
									writer.println("<li>"+ loremWords[j]+ "</li>");
								}
								else {
									writer.println("-" +loremWords[j]);
								}
								
							}
							if(htmlReq) {
								writer.println("</ul>");
							}
						}
						else if(textSrc.equals("anguish")) {
							if(htmlReq) {
								writer.println("<ul>");
							}
							for(int j =0; j< countBullets; j++) {
								if(htmlReq) {
									writer.println("<li>"+ anguishWords[j]+ "</li>");
								}
								else {
									writer.println("-" +anguishWords[j]);
								}
							}
							if(htmlReq) {
								writer.println("</ul>");
							}
						}
						
						
						
					}
					else {
						if(textSrc.equals("lorem")) {
							if(htmlReq) {
								System.out.println("<ul>");
							}
							
							for(int j =0; j< countBullets; j++) {
								
								if(htmlReq) {
									System.out.println("<li>"+ loremWords[j]+ "</li>");
								}
								else {
									
									System.out.println("-"+ loremWords[j]);
								}
							}
							if(htmlReq) {
								System.out.println("</ul>");
							}
						}
						else if(textSrc.equals("anguish")) {
							if(htmlReq) {
								System.out.println("<ul>");
							}
							for(int j =0; j< countBullets; j++) {
								
								if(htmlReq) {
									System.out.println("<li>"+ anguishWords[j]+ "</li>");
								}
								else {
									
									System.out.println("-" +anguishWords[j]);
								}
							}
							if(htmlReq) {
								System.out.println("</ul>");
							}
						}
						
					}
				}//END OF BULLETS CONDITION
				}//END OF IF STMT CHECKING FOR INDEX OUT OF BOUND CONDITION
				else {
					System.out.println("Error: Invalid or empty mode. Please select from 1) paragraphs 2) words 3) bullets");
				}
				
			}//END OF MODE CONDITION
		
		}//END OF LOOP
		
		
		
		}//END OF CML mode
		
			else if(!cmdLineMode) {
				System.out.println("------------------------Interactive Mode-------------------------------------------");
				if (arr.contains("help")) {
					if(arr.size()==1) {
						System.out.println("HELP MENU");
						System.out.println("A star (*) in the description means that the command is standalone. ");
						System.out.println("------------------------------------------------------------------------ ");
						System.out.println("COMMAND LINE MODE: ");
						System.out.println("------------------------------------------------------------------------- ");
						System.out.println("--help, -h: * List the various options and the way in which command can be used  ");
						System.out.println("--version, -v: * Displays the version number of your program  ");
						System.out.println("--library, -l: ");
						System.out.println("--outfile, -o: ");
						System.out.println("--mode, -m <mode>: ");
						System.out.println("--count, -c <count>: ");
						System.out.println("--html, -t: ");
						System.out.println("--generate, -g: ");
						System.out.println("-------------------------------------------------------------------------- ");
						System.out.println("INTERACTIVE MODE: ");
						System.out.println("-------------------------------------------------------------------------- ");
						System.out.println("help: As in command line mode");
						System.out.println("version: As in command line mode");
						System.out.println("set <option> <value>:");
						System.out.println("show <option> <value>:");
						System.out.println("exit or quit:");
					}
					else {
						System.out.println("help is only valid as a stand-alone option");
						System.exit(0); //Exits the loop
					}
					
			
				}//END OF HELP CONDITION
				if (arr.contains("version") ) {
					if(arr.size()==1) {
						System.out.println("Version:1.0 ");
					}
					else {
						System.out.println("version is only valid as a stand-alone option");
						System.exit(0); //Exits the loop
					}
				}//END OF VERSION CONDITION
				
				if(arr.contains("--outfile") || arr.contains("-o")){
					outPutFileReq = true;
					int index = 0;
					if(arr.contains("--outfile")) {
						index = arr.indexOf("--outfile");
					}
					else {
						index = arr.indexOf("-o");
					}
					String fileName = arr.get(index+1);
					
					
					try {
						
				         // create new files
						File f = new File(fileName); 
					
				         
				         // tests if file exists
				         outPutFileExist = f.exists();
				         
				         // prints
				         System.out.println("File exists: "+outPutFileExist);
				         
				         if(outPutFileExist == true) {
				        
				            System.out.println("Error: File already exist");
				            System.exit(0); //Exists the loop
				         }
				         else {
				        		
						         // create new file in the system
						         f.createNewFile();
						         System.out.println("File created:"+ fileName);
						         
				         }
				         
				         
				         
				      } catch(Exception e) {
				         // if any error occurs
				         e.printStackTrace();
				      }
					
					try {
						writer = new PrintWriter(fileName); //overwrites file if already exist else creates file 
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 		
					
				}//END OF OUTFILE CONDITION
				
				if(arr.contains("--count") || arr.contains("-c")){
					int index = 0;
					int countNum= 0;
					
					if(arr.contains("--count")) {
						index = arr.indexOf("--count");
					}
					else if (arr.contains("-c")) {
						index = arr.indexOf("-c");
					}
					
					//System.out.println("index +1: " + (index+1) + "args.len:" + args.length);
					//checks if the the arg after count is an Integer
					if((index+1) < args.length) {
						if(isStringInt(args[index+1])) {
							 countNum = Integer.parseInt(args[index+1]);
							 if(arr.contains("paragraphs")) {
								 countParagraphs = countNum;
								System.out.println("countParagraphs: " + countParagraphs);
								
							}
							else if(arr.contains("words")) {
								countWords = countNum;
								System.out.println("countWords: " + countWords);
							}
							else if(arr.contains("bullets")) {
								countBullets = countNum;
								System.out.println("countBullets: " + countNum);
							}
						}
					}
					
					
			
					
					
					else {
						System.out.println("COUNT ERROR");
					}
					
					
					
				}//END OF COUNT CONDITION
				
				if (arr.contains("--html") || arr.contains("-t") ) { htmlReq = true; }//END OF HTML CONDITION
				
				
				//START OF LOOP
				for (int i =0; i < arr.size(); i++) {
					
					if(arr.get(i).equals("--library") || arr.get(i).equals("-l")){
						textSrc = arr.get(i+1);
						if(textSrc.equals("lorem")){
							if(outPutFileReq) {
								writer.println("https://www.lipsum.com/");
							}
							else {
								System.out.println( "https://www.lipsum.com/");
							}
							
						}
						else if(textSrc.equals("anguish")){
							if(outPutFileReq) {
								writer.println("https://www.crockford.com/wrrrld/anguish.html");
							}
							else {
								System.out.println("https://www.crockford.com/wrrrld/anguish.html");
							}
						}
						else {
							System.out.println("Error library name not valid or selected, please state valid name after library option. Valid names include : 1) lorem 2) anguishh");
						}
						
					}//END OF LIB CONDITION
					
					if(arr.get(i).equals("--mode") || arr.get(i).equals("-m")){
						if(i+1<arr.size()) {
							
						
						if(arr.get(i+1).equals("paragraphs")){
							if(outPutFileReq) {
								if(textSrc.equals("lorem")) {
				
									int counter2 = Math.round((loremWords.length)/countParagraphs);
									if(loremWords.length % 2 != 0) {
										counter2++;
									}
									
									int counterDeno = 1;
									int start = 0;
									
									//System.out.println("loremWords: " + loremWords.length + "Counter2: " + counter2);
									
									
									while(start < loremWords.length) {
										//System.out.println("in loop start:" + start);
										String[] array1= Arrays.copyOfRange(loremWords, start, counter2*counterDeno);
										//System.out.println("new array created");
										start = (counter2*counterDeno);
										counterDeno++;
										//System.out.println("start changed:" + start);
										
										
										for(int j =0; j< array1.length; j++) {
											if(htmlReq & j==0 ) {
												writer.print("<p>");
											}
											
											if(j!=0 & j % 6 == 0 & array1[j]!= null) {//skip to next line
											
										
												
												writer.println(array1[j]+ " ");
												//writer.print("SKIP TO NEXT LINE");
											}
											
											else{ //print on same line
												if(array1[j]!= null & j+1!= array1.length) {
													writer.print(array1[j]+ " ");
													
												}
												else if(array1[j]!= null & j+1==array1.length) {
													writer.print(array1[j]);
												}
												
										
											}
										}
										if(htmlReq) {
											writer.print("</p>");
										}
										
										
										writer.println("\n");
										
										
										
									 
									}
					
									
								}
								else if(textSrc.equals("anguish")) {
									int counter2 = Math.round((anguishWords.length)/countParagraphs);
									if(anguishWords.length % 2 != 0) {
										counter2++;
									}
									
									int counterDeno = 1;
									int start = 0;
									System.out.println("anguishWords: " + anguishWords.length + "Counter2: " + counter2);
									
									
									
									
									while(start < anguishWords.length) {
										System.out.println("in loop start:" + start);
										String[] array1= Arrays.copyOfRange(anguishWords, start, counter2*counterDeno);
										System.out.println("new array created");
										start = (counter2*counterDeno);
										counterDeno++;
										System.out.println("start changed:" + start);
										
										
										for(int j =0; j< array1.length; j++) {
											if(htmlReq & j==0 ) {
												writer.print("<p>");
											}
											if(j!=0 & j % 6 == 0 & array1[j]!= null) {//skip to next line
											
												
												writer.println(array1[j]+ " ");
												//writer.print("SKIP TO NEXT LINE");
											}
											
											else{ //print on same line
												if(array1[j]!= null) {
													writer.print(array1[j]+ " ");
													
												}
												
										
											}
										}
										if(htmlReq) {
											writer.print("</p>");
										}
										
										writer.println("\n");
										
										
										
									 
									}
								}
								
							}
							else if(!outPutFileReq) { //PRINT OUT IN CONSOLE
								if(textSrc.equals("lorem")) {
									
									int counter2 = Math.round((loremWords.length)/countParagraphs);
									if(loremWords.length % 2 != 0) {
										counter2++;
									}
									
									int counterDeno = 1;
									int start = 0;
									
									//System.out.println("loremWords: " + loremWords.length + "Counter2: " + counter2);
									
									
									while(start < loremWords.length) {
										//System.out.println("in loop start:" + start);
										String[] array1= Arrays.copyOfRange(loremWords, start, counter2*counterDeno);
										//System.out.println("new array created");
										start = (counter2*counterDeno);
										counterDeno++;
										//System.out.println("start changed:" + start);
										
										
										for(int j =0; j< array1.length; j++) {
											if(htmlReq & j==0 ) {
												System.out.print("<p>");
											}
											
											if(j!=0 & j % 6 == 0 & array1[j]!= null) {//skip to next line
											
										
												
												System.out.println(array1[j]+ " ");
												//writer.print("SKIP TO NEXT LINE");
											}
											
											else{ //print on same line
												if(array1[j]!= null & j+1!= array1.length) {
													System.out.print(array1[j]+ " ");
													
												}
												else if(array1[j]!= null & j+1==array1.length) {
													System.out.print(array1[j]);
												}
												
										
											}
										}
										if(htmlReq) {
											System.out.print("</p>");
										}
										
										
										System.out.println("\n");
										
										
										
									 
									}
					
									
								}
								else if(textSrc.equals("anguish")) {
									int counter2 = Math.round((anguishWords.length)/countParagraphs);
									if(anguishWords.length % 2 != 0) {
										counter2++;
									}
									
									int counterDeno = 1;
									int start = 0;
									//System.out.println("anguishWords: " + anguishWords.length + "Counter2: " + counter2);
									
									
									
									
									while(start < anguishWords.length) {
										//System.out.println("in loop start:" + start);
										String[] array1= Arrays.copyOfRange(anguishWords, start, counter2*counterDeno);
										//System.out.println("new array created");
										start = (counter2*counterDeno);
										counterDeno++;
										//System.out.println("start changed:" + start);
										
										
										for(int j =0; j< array1.length; j++) {
											if(htmlReq & j==0 ) {
												System.out.print("<p>");
											}
											
											if(j!=0 & j % 6 == 0 & array1[j]!= null) {//skip to next line
											
												
												System.out.println(array1[j]+ " ");
												//writer.print("SKIP TO NEXT LINE");
											}
											
											else{ //print on same line
												if(array1[j]!= null & j+1!= array1.length) {
													System.out.print(array1[j]+ " ");
													
												}
												else if(array1[j]!= null & j+1==array1.length) {
													System.out.print(array1[j]);
												}
												
										
											}
										}
										if(htmlReq) {
											System.out.print("</p>");
										}
										
										System.out.println("\n");
										
										
										
									 
									}
								}
								
								
							}
							
						}//END OF MODE PARAGRAGH 
						else if(arr.get(i+1).equals("words")){
							
							if(outPutFileReq) {
								if(textSrc.equals("lorem")) {
									if(countWords > loremWords.length) {
										System.out.println("Count value exceeds the word count of text, please enter valid word count");
									}
									else {
										
										for(int j =0; j< countWords; j++) {
											if(htmlReq) {
												writer.println("<h1>" + loremWords[j] + "</h1>");
											}
											else {
												writer.println(loremWords[j]);
											}
											
											
										}
										
									}
									
								}
								else if(textSrc.equals("anguish")) {
									if(countWords > anguishWords.length) {
										System.out.println("Count value exceeds the word count of text, please enter valid word count");
									}
									else {
										for(int j =0; j< countWords; j++) {
											if(htmlReq) {
												writer.println("<h1>" + anguishWords[j] + "</h1>");
											}
											else {
												writer.println(anguishWords[j]);
											}
											
										}
									}
									
								}
								
								
								
							}
							else {
								if(textSrc.equals("lorem")) {
									if(countWords > loremWords.length) {
										System.out.println("Count value exceeds the word count of text, please enter valid word count");
									}
									else {
										for(int j =0; j< countWords; j++) {
											if(htmlReq) {
												System.out.println("<h1>" + loremWords[j] + "</h1>");
											}
											else {
												System.out.println(loremWords[j]);
											}
											
											
										}
									}
									
								}
								else if(textSrc.equals("anguish")) {
									if(countWords > anguishWords.length) {
										System.out.println("Count value exceeds the word count of text, please enter valid word count");
									}
									else {
										for(int j =0; j< countWords; j++) {
											if(htmlReq) {
												System.out.println("<h1>" + anguishWords[j] + "</h1>");
											}
											else {
												System.out.println(anguishWords[j]);
											}
											
										}
									}
									
								}
								
							}
						}//END OF MODE WORDS
						else if(arr.get(i+1).equals("bullets")){
							if(outPutFileReq) {
								if(textSrc.equals("lorem")) {
									if(htmlReq) {
										writer.println("<ul>");
									}
									for(int j =0; j< countBullets; j++) {
										if(htmlReq) {
											writer.println("<li>"+ loremWords[j]+ "</li>");
										}
										else {
											writer.println("-" +loremWords[j]);
										}
										
									}
									if(htmlReq) {
										writer.println("</ul>");
									}
								}
								else if(textSrc.equals("anguish")) {
									if(htmlReq) {
										writer.println("<ul>");
									}
									for(int j =0; j< countBullets; j++) {
										if(htmlReq) {
											writer.println("<li>"+ anguishWords[j]+ "</li>");
										}
										else {
											writer.println("-" +anguishWords[j]);
										}
									}
									if(htmlReq) {
										writer.println("</ul>");
									}
								}
								
								
								
							}
							else {
								if(textSrc.equals("lorem")) {
									if(htmlReq) {
										System.out.println("<ul>");
									}
									
									for(int j =0; j< countBullets; j++) {
										
										if(htmlReq) {
											System.out.println("<li>"+ loremWords[j]+ "</li>");
										}
										else {
											
											System.out.println("-"+ loremWords[j]);
										}
									}
									if(htmlReq) {
										System.out.println("</ul>");
									}
								}
								else if(textSrc.equals("anguish")) {
									if(htmlReq) {
										System.out.println("<ul>");
									}
									for(int j =0; j< countBullets; j++) {
										
										if(htmlReq) {
											System.out.println("<li>"+ anguishWords[j]+ "</li>");
										}
										else {
											
											System.out.println("-" +anguishWords[j]);
										}
									}
									if(htmlReq) {
										System.out.println("</ul>");
									}
								}
								
							}
						}//END OF BULLETS CONDITION
						}//END OF IF STMT CHECKING FOR INDEX OUT OF BOUND CONDITION
						else {
							System.out.println("Error: Invalid or empty mode. Please select from 1) paragraphs 2) words 3) bullets");
						}
						
					}//END OF MODE CONDITION
				
				}//END OF LOOP
				
				if(outPutFileReq) {
					writer.close(); //Closes file if output file specified 
				}
			
			
			
			
			
			
			}//END OF INTERCATIVE MODE 
		
	}//END OF MAIN

} //END OF CLASS
