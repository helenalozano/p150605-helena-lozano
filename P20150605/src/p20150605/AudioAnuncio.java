package p20150605;

import java.io.File;
import java.util.Date;
/**
 * Esta clase es para gestionar cuñas de anuncios publicitarios en radio.
 * @version 1.0.1
 * @author Helena
 */

public class AudioAnuncio extends AudioPista
/**
 * Cada objeto se referira a una cuña diferente.
 * Permite programar la cuña dentro de una secuencia de audio clips y exportar 
 * la cuña completa a un formato propio.
 */
{
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    
    public AudioAnuncio ()
            
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    /**
     * Establece los metadatos del spot
     * @param producto Establece el nombre del producto
     * @param anunciante Establece el nombre del anunciante
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }

    protected int Rutina() {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        return resultado;
    }
    
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        int resultado = Rutina();
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
