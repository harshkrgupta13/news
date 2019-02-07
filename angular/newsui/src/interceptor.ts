import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './app/auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor (private authService : AuthService){}
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
        let token = this.authService.getToken();
        console.log(token)
       // const re = 'https://newsapi.org/';
       // if (request.url.search(re) === -1) {
        if (token) {
            console.log('Adding Token .........!!')
            request = request.clone({
                setHeaders: { 
                    Authorization: `Token ${token}`
                }
            });
        }

        return next.handle(request);
    }
}
