using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;

namespace api
{
    public class Program
    {
        public static void Main(string[] args)
        {
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    webBuilder.UseStartup<Startup>();
                });
    }
}
// Urqnvv2z9ZhTlbfV

//mongodb+srv://api:<password>@cluster0.ghcbp.mongodb.net/<dbname>?retryWrites=true&w=majority
//mongodb+srv://api:Urqnvv2z9ZhTlbfV@cluster0.ghcbp.mongodb.net/<dbname>?retryWrites=true&w=majority