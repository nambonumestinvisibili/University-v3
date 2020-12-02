using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace KursWWW.Models
{
    public class Transfer
    {

        public int TransferID { get; set; }
        [Required]
        [RegularExpression(@"^\d\d 1234 9876 (\d{4} ){3}\d{4}$", 
            ErrorMessage = "Account number msut be typed as XX XXXX XXXX XXXX XXXX XXXX XXXX")]
        public string AccountNumberFrom { get; set; }
        [Required]
        [RegularExpression(@"^\d\d (\d{4} ){5}\d{4}$",
            ErrorMessage = "Account number must be typed as XX XXXX XXXX XXXX XXXX XXXX XXXX")]
        public string AccountNumberTo { get; set; }

        [Required]
        [StringLength(30, MinimumLength =1)]
        public string NameSurname { get; set; }

        [Required]
        [StringLength(30, MinimumLength = 1)]
        public string Street { get; set; }

        [Required]
        [StringLength(30, MinimumLength = 1)]
        public string City { get; set; }

        [Required]
        [RegularExpression(@"^\d\d-\d{3}$")]
        [DataType(DataType.PostalCode)]
        public string PostalCode { get; set; }

        [Required]
        [DataType(DataType.Currency)]
        public float Amount { get; set; }

        [Required]
        [StringLength(60, MinimumLength = 1)]
        public string Title { get; set; }

        [Required]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime ExecutionDate { get; set; } = DateTime.Now;
       
    }

    
    public class TransferDbContext : DbContext
    {

        public TransferDbContext(DbContextOptions<TransferDbContext> options) 
            : base(options)
        {

        }
        public DbSet<Transfer> Transfers { get; set; }
    }
}

