package com.LigaAcademic.AcademicProject.service;

import com.LigaAcademic.AcademicProject.model.GuildasModel;
import com.LigaAcademic.AcademicProject.repository.GuildasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuildasService {

    @Autowired
    private GuildasRepository guildasRepository;


    public void registrarGuilda(GuildasModel novaguilda){
       if( novaguilda.getNome_guilda() == null || novaguilda.getNome_guilda().trim().isEmpty()){
           System.out.println("Adicione o nome da guilda");
           return;
       }
       if(novaguilda.getTutor_guildas() == null || novaguilda.getTutor_guildas().trim().isEmpty()){
           System.out.println("Adicione o nome do tutor");
           return;
       }
       guildasRepository.save(novaguilda);
    }

    public void removerGuilda(Long id){
        if(id == null || id == 0){
            System.out.println("O id da matricula não pode ser nulo ou 0");
        }

        GuildasModel guildaParaRemover = guildasRepository.getById(id);

        if(guildaParaRemover != null){
            guildasRepository.delete(guildaParaRemover);
        }else{
            System.out.println("Guilda com esse ID não encontrada");
        }

    }

}
