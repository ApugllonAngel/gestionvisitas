/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.gestionvisitas.controller;

import com.uisrael.gestionvisitas.modelo.edentidad.Tecnico;
import java.util.List;

/**
 *
 * @author XTREME
 */
public interface ITecnicoController {
    public void insertarTecnico (Tecnico tecnico);
    public List listarTecnico();
    public void actualizarTecnico(Tecnico tecnico);
    public void eliminarTecnico(Tecnico tecnico);
    
}
