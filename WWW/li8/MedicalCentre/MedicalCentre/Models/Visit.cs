using System.ComponentModel.DataAnnotations;

namespace MedicalCentre.Models
{
    public class Visit
    {
        [Key]
        public int Id { get; set; }
        public string Date { get; set; }
        [Required]
        public bool IsPaid { get; set; }
        public long Prescription { get; set; }
        public int PatientId { get; set; }

    }
}
