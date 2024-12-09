package cl.prestabanco.documents_server.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "documents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idDocument;

    @Column(nullable = false)
    private Integer idRequest;

    @Column(nullable = false)
    private String fileName;

    @Lob
    @Column(nullable = false)
    @Basic(fetch = FetchType.LAZY)
    private byte[] fileContent;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date uploadDateDocument;
}

