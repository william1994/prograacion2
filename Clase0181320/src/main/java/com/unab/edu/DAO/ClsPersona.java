/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Persona;
import com.unab.edu.conexionamysql.ConexionDB;
import java.sql.*;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 14-ck0013lab
 */
public class ClsPersona {

    ConexionDB conectarclase = new ConexionDB();
    Connection conectar = conectarclase.retornarConexion();

    public ArrayList<Persona> MostrarPersona() {
        ArrayList<Persona> Personas = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_Persona ()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(resultadoDeConsulta.getInt("idPersona"));
                persona.setNombre(resultadoDeConsulta.getString("Nombre"));
                persona.setApellido(resultadoDeConsulta.getString("Apellido"));
                persona.setEdad(resultadoDeConsulta.getInt("Edad"));
                persona.setSexo(resultadoDeConsulta.getString("Sexso"));
                Personas.add(persona);
            }
            conectar.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return Personas;
    }

    public void AgregarPersonas(Persona Per) {

        try {
            CallableStatement Statement = conectar.prepareCall("Call SP_I_persona(?,?,?,?)");
            Statement.setString("PNombre", Per.getNombre());
            Statement.setString("PApellido", Per.getApellido());
            Statement.setInt("PEdad", Per.getEdad());
            Statement.setString("PSexo", Per.getSexo());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CON EXITO!");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void EliminarPersonas(Persona Per) {

        try {
            CallableStatement Statement = conectar.prepareCall("Call SP_D_persona(?)");
            Statement.setInt("PIdPersona", Per.getIdPersona());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS CON EXITO!");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void ActualizarPersonas(Persona Per) {

        try {
            CallableStatement Statement = conectar.prepareCall("Call SP_U_persona(?,?,?,?,?)");
            Statement.setInt("PIdPersona", Per.getIdPersona());
            Statement.setString("PNombre", Per.getNombre());
            Statement.setString("PApellido", Per.getApellido());
            Statement.setInt("PEdad", Per.getEdad());
            Statement.setString("PSexo", Per.getSexo());
            Statement.execute();
            conectar.close();
            JOptionPane.showMessageDialog(null, "DATOS ATUALIZADOS CON EXITO!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
