import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class CifradoCesar {

       
    static String min = "abcdefghijklmnopqrstuvwxyz"; 
    //static String min = "abcdefghijklmnñopqrstuvwxyz"; //<- Con la Letra Ñ
    static String max = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //static String max = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; //<- Con la Letra Ñ
   static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
   
    public static void main(String[] args){ 
        try { //<- Si quieres meter números en vez de letras
        String texto = "";
        int n=0;            
        System.out.println("Texto a cifrar"); 
        texto = bf.readLine(); //<-Lee la palaba a cifrar
        System.out.println("Desplazamiento para el cifrado.(numero entero)"); 
        n = Integer.parseInt(bf.readLine()); //<- Lee el recorrido
        if (n<=0){
            System.out.println("No puedes cifrar en cero o negativo");
        }else{
        System.out.println(); 
        System.out.println("Texto: "+texto); //<- imprime el texto no cifrado
        System.out.println("Texto cifrado: "+cifCesar(texto,n)); //<- llama el metodo e imprime el texto cifrado
        }
        } catch (IOException | NumberFormatException e) { 
            System.out.print("Valor no valido."); 
        } 
        
    } 
     
    private static String cifCesar(String entrada,int desp){ 
        String salida = ""; 
        for(int i = 0;i<entrada.length();i++){
            if((min.indexOf(entrada.charAt(i)) != -1) || (max.indexOf(entrada.charAt(i)) != -1)) 
            //Signo "?" Operador ternario como un if-then-else
                salida += (min.indexOf(entrada.charAt(i)) != -1) ? min.charAt(( (min.indexOf(entrada.charAt(i)) )+desp)%min.length() ) : max.charAt(( max.indexOf(entrada.charAt(i)) +desp)%max.length()); 
            else 
                salida += entrada.charAt(i); 
        } 
        return salida; 
    }
}