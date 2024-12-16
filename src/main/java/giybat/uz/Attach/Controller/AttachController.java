package giybat.uz.Attach.Controller;

import giybat.uz.Attach.dto.AttachDTO;
import giybat.uz.Attach.dto.DovnloadDTO;
import giybat.uz.Attach.entity.AttachEntity;
import giybat.uz.Attach.service.AttachService;
import giybat.uz.ExceptionHandler.AppBadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/attach")
public class AttachController {
    @Autowired
    private AttachService attachService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        AttachDTO upload = attachService.upload(file);
        return ResponseEntity.ok(upload);
    }

    @GetMapping("/open/name/{fileName}")
    public ResponseEntity<Resource> open(@PathVariable String fileName) {
        return attachService.open(fileName);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/open")
    public ResponseEntity<?> open(@RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        Page<AttachEntity> attachEntities = attachService.allAttaches(page - 1, size);
        return ResponseEntity.ok().body(attachEntities);
    }

//    @GetMapping("/download/{fileName}")
//    public ResponseEntity<Resource> download(@PathVariable("fileName") String fileName) {
//        DovnloadDTO download = attachService.download(fileName);
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//                "attachment; filename=\"" + download.getName() + "\"").body(download.getResource());
//    }


    @ExceptionHandler({AppBadException.class, IllegalArgumentException.class})
    public ResponseEntity<?> handle(AppBadException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
