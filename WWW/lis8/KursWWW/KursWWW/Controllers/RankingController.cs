using KursWWW.Data;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace KursWWW.Controllers
{
    public class RankingController : Controller
    {
        private readonly IParticipantsRepo _participantsRepo;
        
        public RankingController(IParticipantsRepo participantsRepo)
        {
            _participantsRepo = participantsRepo;
        }

        // GET: RankingController
        public ActionResult Index()
        {
            var listOfParticipants = _participantsRepo
                .GetAllParticipants()
                .OrderByDescending(o => o.NumberOfPoints);
            
            return View(listOfParticipants);
        }
    }
}
