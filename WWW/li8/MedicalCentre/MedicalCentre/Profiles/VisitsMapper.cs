using MedicalCentre.DTOs;
using MedicalCentre.Models;
using System.Collections.Generic;

namespace MedicalCentre.Profiles
{
    public class VisitsMapper : IVisitsMapper
    {
        private string Self = "self";
        private string VisitsRoute = "/api/visits/";
        private List<string> Methods = new List<string> { "GET", "PUT", "PATCH", "DELETE" };
        private List<string> Actions = new List<string> { "get visit", "update visit", "update visit", "delete visit" };
        enum MethodsIdx
        {
            GET, PUT, PATCH, DELETE
        }
        private List<Link> CreateActionLinks(string route)
        {
            List<Link> links = new List<Link>();

            for (int i = 0; i < Methods.Count; i++)
            {
                Link link = new Link { Href = route, Method = Methods[i], Rel = Actions[i] };
                links.Add(link);
            }

            return links;
        }

        public VisitGeneralReadDTO ConvertVisitToGeneralReadDTO(Visit visit)
        {
            string route = VisitsRoute + visit.Id;
            Link link = new Link
            {
                Href = route,
                Rel = Actions[(int)MethodsIdx.GET],
                Method = Methods[(int)MethodsIdx.GET]
            };
            return new VisitGeneralReadDTO
            {
                Id = visit.Id,
                linkToSelf = link,
                Date = visit.Date
            };
        }

        public VisitDetailReadDTO ConvertVisitToDetailReadDTO(Visit visit)
        {
            Link linkToPatient = new Link
            {
                Href = "/api/patients/" + visit.PatientId,
                Method = Methods[(int)MethodsIdx.GET],
                Rel = "patient"
            };

            string route = VisitsRoute + visit.Id;
            List<Link> selfLinks = CreateActionLinks(route);

            return new VisitDetailReadDTO
            {
                Id = visit.Id,
                Links = selfLinks,
                Patient = linkToPatient,
                Date = visit.Date,
                IsPaid = visit.IsPaid,
                Prescription = visit.Prescription
            };
        }
    }
}
