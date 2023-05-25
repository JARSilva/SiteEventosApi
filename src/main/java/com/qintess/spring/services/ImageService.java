package com.qintess.spring.services;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	//@Value("${imagem.pasta.destino}")
    private static String pastaDestino; // Caminho para a pasta de destino configurado no application.properties

	public static ResponseEntity<String> copyImage(MultipartFile imagem) {
        try {
        	pastaDestino = "/SiteEventosApi/src/main/resources/imagens";
            String nomeImagem = imagem.getOriginalFilename();
            File destino = new File(pastaDestino + File.separator + nomeImagem);
            FileUtils.writeByteArrayToFile(destino, imagem.getBytes());
            return ResponseEntity.ok("Imagem copiada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao copiar a imagem.");
        }
    }
}