import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DepshelperSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
import { HomeComponent } from './home.component';

@NgModule({
  imports: [DepshelperSharedModule, RouterModule.forChild([HOME_ROUTE])],
  declarations: [HomeComponent]
})
export class DepshelperHomeModule {}
