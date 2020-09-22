using MedicalCentre.DTOs;
using MedicalCentre.Models;
using System.Collections.Generic;

namespace MedicalCentre.Profiles
{
    public class PatientsMapper : IPatientsMapper
    {
        private string Self = "self";
        private string PatientsRoute = "/api/patients/"; //How to have this not hard-coded??????????????????
        private List<string> Methods = new List<string> { "GET", "PUT", "PATCH", "DELETE" };
        private List<string> Actions = new List<string> { "get patient", "update patient", "update patient", "delete patient" };
        enum MethodsIdx
        {
            GET, PUT, PATCH, DELETE
        }

        public PatientGeneralReadDTO ConvertPatientToGeneralReadDTO(Patient patient)
        {
            
            string route = PatientsRoute + patient.Id;
            Link link = new Link { Href = route, 
                                   Method = Methods[(int)MethodsIdx.GET], 
                                   Rel = Self };

            return new PatientGeneralReadDTO { linkToSelf = link, Name = patient.Name, 
                                               Pesel = patient.Pesel, Surname = patient.Surname };
        }

        public PatientDetailReadDTO ConvertPatientToDetailReadDTO(Patient patient)
        {
            Link linkToVisits = new Link { Href = PatientsRoute + patient.Id + "/visits",
                                           Method = Methods[(int)MethodsIdx.GET],
                                           Rel = "visits" };
            
            string route = PatientsRoute + patient.Id;
            List<Link> selfLinks = CreateActionLinks(route);

            return new PatientDetailReadDTO
            {
                Id = patient.Id,
                Name = patient.Name,
                Surname = patient.Surname,
                Pesel = patient.Pesel,
                Visits = linkToVisits,
                Links = selfLinks
            };
        }

        private List<Link> CreateActionLinks(string route)
        {
            List<Link> links = new List<Link>();

            for (int i = 0; i < Methods.Count; i++)
            {
                Link link = new Link { Href = route, Method = Methods[i], Rel = Actions[i], Fields = new List<string>() };
                if (link.Method == "POST")
                {
                    link.Fields.Add("Name");
                    link.Fields.Add("Surname");
                    link.Fields.Add("PESEL");
                }
                links.Add(link);
            }

            return links;
        }

        public Patient ConvertPatientCreateDTOToPatient(PatientCreateDTO patient)
        {
            return new Patient
            {
                Id = 0,
                Name = patient.Name,
                Surname = patient.Surname,
                Pesel = patient.Pesel,
                VisitsId = new List<int>()
            };
        }
    }
}
