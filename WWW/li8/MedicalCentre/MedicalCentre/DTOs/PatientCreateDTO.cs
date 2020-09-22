using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.DTOs
{
    public class PatientCreateDTO
    {
        public string Name { get; set; }
        public string Surname { get; set; }
        [Required]
        public long Pesel { get; set; }
    }
}
