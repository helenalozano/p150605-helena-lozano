/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;
import java.sql.Date;

/**
 *
 * @author Helena
 */
public abstract class AudioPista {
    protected File archivo; // manejador para el archivo que contiene el audio (.mp3)
    protected int duracion; // duración del audio, en segundos
    public String lasterrormsg;

    public AudioPista() {
    }

    /**
     * Establece los metadatos del spot
     * @param producto Establece el nombre del producto
     * @param anunciante Establece el nombre del anunciante
     */
    public abstract void setMetaDatos(String producto, String anunciante);

    /**
     * Establece la duracion
     * @param duracion Establece el tiempo del spot
     * @throws IllegalArgumentException El spot no debe ser demasiado largo
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > 120) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     * Establece que exista el archivo, si no, lo crea.
     * @param nombre_archivo Busca si existe el nobmre del archivo
     * @return Devuelve true o false dependiendo de si existe o no
     */
    public Boolean setArchivo(String nombre_archivo) {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }

    /**
     * Recoge errores en el caso de que salga un numero entero negativo
     * @param cola_reproduccion Es el conjunto de todos los atributos
     * @return El mensaje de error del numero que devuelva
     */
    public int ProgramaEnCola(Object cola_reproduccion, Date par1) {
        int resultado = Rutina();
        // si todo va bien, programamos
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }

    protected abstract int Rutina();

    public abstract int ExportaAFormatoDAW(Object objeto_daw);
    
}
