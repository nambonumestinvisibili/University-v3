using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace KursWWW.Controllers
{
    public class WebsiteController : Controller
    {

        public IActionResult Index()
        {
            ViewData["Title"] = "The best bank in Poland";
            return View();
        }

        public IActionResult CountryTransfers()
        {
            ViewData["Title"] = nameof(CountryTransfers);
            return View();
        }

        public IActionResult ListOfTransfers(string date, float cash)
        {
            try
                {
                    if (date == null || cash == null) {
                    ViewData["Info"] = "Parameters not specified";
                    return View();
                }
            
                    DateTime dateTime = DateTime.ParseExact(date, "yyyyMMdd", System.Globalization.CultureInfo.InvariantCulture);
            

                if (dateTime < DateTime.Now || cash <= 0) {
                    ViewData["Date"] = "Invalid Date Try Again";
                    ViewData["Cash"] = "Invalid Money Amount Try Again";
                    return View();
                }
            


                ViewData["Cash"] = cash;
                ViewData["Date"] = dateTime;
                ViewData["Title"] = "List of trasnfers";
                return View();
            }
            catch (FormatException)
            {
                ViewData["Date"] = "Invalid Date Try Again";
                return View();
            }
        }
        public IActionResult CreditCards()
        {
            ViewData["Title"] = "Credit cards";
            return View();
        }
        public IActionResult AccountCards()
        {
            ViewData["Title"] = "Account cards";
            return View();
        }
    }
}
