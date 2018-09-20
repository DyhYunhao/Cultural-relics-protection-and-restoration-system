package randp.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2017/4/13.
 */
public class FileUploader1 {
    public static String upload(MultipartFile file, HttpSession session) {
        String data = "";
        if(file != null) {
            String fileOriginName = file.getOriginalFilename();
            String ext = fileOriginName.substring(fileOriginName.lastIndexOf('.'));
            String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            String path = session.getServletContext().getRealPath("/file/up/" + date);
            String fileName = System.currentTimeMillis() + ext;
            data = "/file/up/" + date + "/" + fileName;

            File dir = new File(path, fileName);
            System.err.println(fileName);
            if(!dir.exists()) {
                dir.mkdirs();
            }

            try {
                file.transferTo(dir);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
