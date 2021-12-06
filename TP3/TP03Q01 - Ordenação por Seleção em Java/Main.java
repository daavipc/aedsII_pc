import java.io.*;
import java.io.FileReader;
import java.io.File;  
import java.io.IOException;
import java.util.Scanner;

class Serie{
private String name;
private String format;
private String duration;
private String country;
private String language;
private String broadcaster;
private String streaming;
private int seasons;
private int episodes;

public Serie(){
name = "";
format = "";
duration = "";
country = "";
language = "";
broadcaster = "";
streaming = "";
seasons = 0;
episodes = 0;
}

public Serie(String name, String format, String duration, String country, String language, String broadcaster, String streaming, int seasons, 
int episodes){
this.name = name;
this.format = format;
this.duration = duration;
this.country = country;
this.language = language;
this.broadcaster = broadcaster;
this.streaming = streaming;
this.seasons = seasons;
this.episodes = episodes;
}

public void setName(String name){
this.name = name;
}

public void setFormat(String format){
this.format = format;
}

public void setDuration(String duration){
this.duration = duration;
}

public void setCountry(String country){
this.country = country;
}

public void setLanguage(String language){
this.language = language;
}

public void setBroadcaster(String broadcaster){
this.broadcaster = broadcaster;
}

public void setStreaming(String streaming){
this.streaming = streaming;
}

public void setSeasons(int seasons){
this.seasons = seasons;
}

public void setEpisodes(int episodes){
this.episodes = episodes;
}

public String getName(){ 
return this.name; 
}

public String getFormat(){ 
return this.format; 
}

public String getDuration(){ 
return this.duration; 
}

public String getCountry(){ 
return this.country; 
}

public String getLanguage(){ 
return this.language; 
}

public String getBroadcaster(){ 
return this.broadcaster; 
}

public String getStreaming(){ 
return this.streaming; 
}

public int getSeasons(){ 
return this.seasons; 
}

public int getEpisodes(){ 
return this.episodes; 
}

public Serie clone(){
Serie resp = new Serie();
resp.name = this.name;
resp.format = this.format;
resp.duration = this.duration;
resp.country = this.country;
resp.language = this.language;
resp.broadcaster = this.broadcaster;
resp.streaming = this.streaming;
resp.seasons = this.seasons;
resp.episodes = this.episodes;
return resp;
}

public void printClass(){
System.out.println(this.name + " " + this.format + " " + this.duration + " " + this.country + " " + this.language + " " + this.broadcaster + " " +
this.streaming + " " + this.seasons + " " + this.episodes);
}

public int justInt(String line){
String resp = "";
for(int i = 0; i < line.length(); i++){
if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ 
resp += line.charAt(i);
} else {
i = line.length();
}
}
return Integer.parseInt(resp); 
}

public String removeTags(String line){
String resp = "";
int i = 0;
while(i < line.length()){
if(line.charAt(i) == '<'){
i++;
while(line.charAt(i) != '>') i++;
} else if(line.charAt(i) == '&'){
i++;
while(line.charAt(i) != ';') i++;
} else {
resp += line.charAt(i);
}
i++;
}

return resp;
}

public String searchName(String fileName){
String resp = "";
for(int i = 0; i < fileName.length(); i++){
if(fileName.charAt(i)  == '_'){
resp += ' ';
} else {
resp += fileName.charAt(i);
}
}
return resp.substring(0, resp.length()-5);
}

public void readClass(String fileName){
String line;
String resp = "";
String file = "/tmp/series/" + fileName;
try {
FileReader fileReader = new FileReader(file);

BufferedReader br = new BufferedReader(fileReader);

this.name = searchName(fileName);

while(!br.readLine().contains("Formato"));
this.format = removeTags(br.readLine());

while(!br.readLine().contains("Duração"));
this.duration = removeTags(br.readLine());

while(!br.readLine().contains("País de origem"));
this.country = removeTags(br.readLine());
this.country = this.country.trim();

while(!br.readLine().contains("Idioma original"));
this.language = removeTags(br.readLine());

while(!br.readLine().contains("Emissora de televisão"));
this.broadcaster = removeTags(br.readLine());

while(!br.readLine().contains("Transmissão original"));
this.streaming = removeTags(br.readLine());

while(!br.readLine().contains("N.º de temporadas"));
this.seasons = justInt(removeTags(br.readLine()));

while(!br.readLine().contains("N.º de episódios"));
this.episodes = justInt(removeTags(br.readLine()));

br.close();         
} catch(FileNotFoundException e) {

} catch(IOException e) {

}
}
}

public class Main{
public static void matricula(long time, int contador){ 

try {
File file = new File("matselecao.txt");
if (file.createNewFile()) {
} else { }
} catch (IOException e) {
e.printStackTrace();
}

try {
FileWriter input = new FileWriter("matselecao.txt");
input.write("728764" + "\t" + time + "\t" + contador);
input.close();
} catch (IOException e) {
e.printStackTrace();
}

}

public static boolean returnEnd(String fim){
boolean result;

result = (fim.length() == 3 && fim.charAt(0) == 'F' && fim.charAt(1) == 'I' && fim.charAt(2) == 'M');

return result;
}

public static void main(String args[]){

Scanner teclado = new Scanner(System.in);
long startTime = System.nanoTime(); 
int inputCounter = 0;
int contaodrDeRepeticoes = 0;
Serie[] arrayDeSeries = new Serie[100];
String input;
int i = 0;

while(true){
Serie serie = new Serie();
input = teclado.nextLine();
if(returnEnd(input) == true)
break;
serie.readClass(input);
arrayDeSeries[inputCounter++] = serie;

}		

for(i = 0; i < inputCounter; i++){

for(int j = i + 1; j < inputCounter; j++){
if((arrayDeSeries[i].getCountry()).compareTo(arrayDeSeries[j].getCountry()) > 0){
Serie aux = arrayDeSeries[i];
arrayDeSeries[i] = arrayDeSeries[j];
arrayDeSeries[j] = aux;
}
if((arrayDeSeries[i].getCountry()).compareTo(arrayDeSeries[j].getCountry()) == 0 ){
if((arrayDeSeries[i].getName()).compareTo(arrayDeSeries[j].getName())> 0){
Serie aux = arrayDeSeries[i];
arrayDeSeries[i] = arrayDeSeries[j];
arrayDeSeries[j] = aux;
}
}
contaodrDeRepeticoes++;
}
}

for(i = 0; i < inputCounter; i++)
{
arrayDeSeries[i].printClass();
}

long endTime = System.nanoTime();
long duration = (endTime - startTime);
matricula(duration, contaodrDeRepeticoes);

teclado.close();
}

}