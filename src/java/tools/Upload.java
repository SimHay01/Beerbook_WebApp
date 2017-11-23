/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.faces.bean.ManagedBean;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;


@ManagedBean
public class Upload {
    
    //private UploadedFile uploadedFile;
    private Path file;

    public void upload(UploadedFile uf, String whatAdd) throws IOException {
        if (uf != null) {
            InputStream input = uf.getInputstream();
            Path folder = Paths.get("C:/workspace/Dernier_code/Beerbook_WebApp/web/" + whatAdd);
            String filename = FilenameUtils.getBaseName(uf.getFileName());
            String extension = FilenameUtils.getExtension(uf.getFileName());
            file = Files.createTempFile(folder, filename + "-", "." + extension);
            try (InputStream input2 = uf.getInputstream()) {
                Files.copy(input2, file, StandardCopyOption.REPLACE_EXISTING);
            }            
            file = Paths.get(file.toString());            
        }
        //return null;
    } 

    public Path getFile() {
        return file;
    }

    public void setFile(Path file) {
        this.file = file;
    }
    
    

}
