// @PostMapping(value = "uploads/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
// @PreAuthorize("hasRole('ROLE_ADMIN')")
// public ResponseEntity<?> uploadImages(
//         @PathVariable("id") Long productId,
//         @ModelAttribute("files") List<MultipartFile> files) {
//     try {
//         Product existingProduct = productService.getProductById(productId);
//         files = files == null ? new ArrayList<MultipartFile>() : files;
//         if (files.size() > ProductImage.MAXIMUM_IMAGES_PER_PRODUCT) {
//             return ResponseEntity.badRequest().body(localizationUtils
//                     .getLocalizedMessage(MessageKeys.UPLOAD_IMAGES_MAX_5));
//         }
//         List<ProductImage> productImages = new ArrayList<>();
//         for (MultipartFile file : files) {
//             if (file.getSize() == 0) {
//                 continue;
//             }
//             // Kiểm tra kích thước file và định dạng
//             if (file.getSize() > 10 * 1024 * 1024) { // Kích thước > 10MB
//                 return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
//                         .body(localizationUtils
//                                 .getLocalizedMessage(MessageKeys.UPLOAD_IMAGES_FILE_LARGE));
//             }
//             String contentType = file.getContentType();
//             if (contentType == null || !contentType.startsWith("image/")) {
//                 return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//                         .body(localizationUtils.getLocalizedMessage(MessageKeys.UPLOAD_IMAGES_FILE_MUST_BE_IMAGE));
//             }
//             // Lưu file và cập nhật thumbnail trong DTO
//             String filename = storeFile(file); // Thay thế hàm này với code của bạn để lưu file
//             // lưu vào đối tượng product trong DB
//             ProductImage productImage = productService.createProductImage(
//                     existingProduct.getId(),
//                     ProductImageDTO.builder()
//                             .imageUrl(filename)
//                             .build());
//             productImages.add(productImage);
//         }
//         return ResponseEntity.ok().body(productImages);
//     } catch (Exception e) {
//         return ResponseEntity.badRequest().body(e.getMessage());
//     }
// }

// @GetMapping("/images/{imageName}")
// public ResponseEntity<?> viewImage(@PathVariable String imageName) {
//     try {
//         java.nio.file.Path imagePath = Paths.get("uploads/" + imageName);
//         UrlResource resource = new UrlResource(imagePath.toUri());

//         if (resource.exists()) {
//             return ResponseEntity.ok()
//                     .contentType(MediaType.IMAGE_JPEG)
//                     .body(resource);
//         } else {
//             return ResponseEntity.ok()
//                     .contentType(MediaType.IMAGE_JPEG)
//                     .body(new UrlResource(Paths.get("uploads/notfound.jpeg").toUri()));
//             // return ResponseEntity.notFound().build();
//         }
//     } catch (Exception e) {
//         return ResponseEntity.notFound().build();
//     }
// }