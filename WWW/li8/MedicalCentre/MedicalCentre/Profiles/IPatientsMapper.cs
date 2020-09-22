using MedicalCentre.DTOs;
using MedicalCentre.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MedicalCentre.Profiles
{
    public interface IPatientsMapper
    {
        public PatientGeneralReadDTO ConvertPatientToGeneralReadDTO(Patient patient);
        public PatientDetailReadDTO ConvertPatientToDetailReadDTO(Patient patient);
        public Patient ConvertPatientCreateDTOToPatient(PatientCreateDTO patient);
    }
}
