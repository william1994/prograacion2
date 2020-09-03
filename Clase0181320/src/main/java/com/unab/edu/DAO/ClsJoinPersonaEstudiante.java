/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Estudiante;
import com.unab.edu.conexionamysql.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class ClsJoinPersonaEstudiante {

    ConexionDB cn = new ConexionDB();
    Connection con = cn.retornarConexion();

    public ArrayList<Estudiante> MosrarJoinEstudiantePersona() {

        ArrayList<Estudiante> lista = new ArrayList<>();

        try {
            CallableStatement st = con.prepareCall("call SP_S_JOINPERSONAESTUDIANTE ()");

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Estudiante es = new Estudiante();
                es.setNombre(rs.getString("nombre"));
                es.setApellido(rs.getString("apellido"));
                es.setMartricula(rs.getInt("matricula"));

                lista.add(es);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return lista;

    }

}
